package com.ecommerce.bicicle.service.impl;

import com.ecommerce.bicicle.dto.ItemFloatingCharsRelDto;
import com.ecommerce.bicicle.dto.ItemSavedDto;
import com.ecommerce.bicicle.entity.ItemEntity;
import com.ecommerce.bicicle.entity.ItemFloatingCharsRelEntity;
import com.ecommerce.bicicle.entity.UserEntity;
import com.ecommerce.bicicle.mapper.ItemMapper;
import com.ecommerce.bicicle.mapper.ItemSaveMapper;
import com.ecommerce.bicicle.repository.ItemEntityRepository;
import com.ecommerce.bicicle.repository.ItemFloatingCharsRelRepository;
import com.ecommerce.bicicle.repository.UserRepository;
import com.ecommerce.bicicle.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemEntityRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemFloatingCharsRelRepository itemFloatingCharsRelRepository;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemSaveMapper itemSaveMapper;

    @Override
    public List<ItemSavedDto> get() {

        List<ItemEntity> items = StreamSupport.stream(
                itemRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return items.parallelStream().map(ItemSavedDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ItemSavedDto> getItemsByType(int itemTypeCatId) {

        List<ItemEntity> items = itemRepository.findByItemTypeCatId(itemTypeCatId);

        return items.parallelStream().map(ItemSavedDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ItemSavedDto> getItemsByUser(int userId) {

        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if(!userEntity.isPresent()) {
            return null;
        }
        List<ItemEntity> items = itemRepository.findByUser(userEntity.get());

        return items.parallelStream().map(ItemSavedDto::new).collect(Collectors.toList());
    }

    @Override
    public ItemSavedDto save(ItemSavedDto itemDTo) {
        //1. Map to Entity
        ItemEntity item = itemSaveMapper.toItemEntity(itemDTo);
        //2. Save
        item = this.itemRepository.save(item);

        List<ItemFloatingCharsRelDto> floatingCharsRelated = itemDTo.getItemFloatingChars();

        ItemEntity finalItem = item;
        floatingCharsRelated.forEach(floatingCharsRelDto -> {

            ItemFloatingCharsRelEntity charsRelEntity = new ItemFloatingCharsRelEntity()
                    .setItemId(finalItem.getId())
                    .setFloatingCharCatId(floatingCharsRelDto.getFloatingCharCatId())
                    .setFloatingCharId(floatingCharsRelDto.getFloatingCharId());

            itemFloatingCharsRelRepository.save(charsRelEntity);
        });
        List<ItemFloatingCharsRelEntity> relResult = itemFloatingCharsRelRepository.findByItemId(item.getId());
        //3. Map to Dto
        return new ItemSavedDto(item);
    }

    @Override
    public void delete(Integer itemId) {

        try {
            this.itemRepository.deleteById(itemId);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("already deleted");
        }
    }

}
