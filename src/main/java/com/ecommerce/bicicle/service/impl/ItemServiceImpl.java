package com.ecommerce.bicicle.service.impl;

import com.ecommerce.bicicle.dto.ItemDto;
import com.ecommerce.bicicle.dto.UserItemsDto;
import com.ecommerce.bicicle.entity.ItemEntity;
import com.ecommerce.bicicle.entity.UserEntity;
import com.ecommerce.bicicle.mapper.ItemMapper;
import com.ecommerce.bicicle.repository.ItemEntityRepository;
import com.ecommerce.bicicle.repository.UserRepository;
import com.ecommerce.bicicle.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ItemMapper itemMapper;

    public List<ItemDto> get() {

        List<ItemEntity> items = StreamSupport.stream(
                itemRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return items.parallelStream().map(ItemDto::new).collect(Collectors.toList());
    }

    public List<ItemDto> getItemsByType(int itemTypeCatId) {

        List<ItemEntity> items = itemRepository.findByItemTypeCatId(itemTypeCatId);

        return items.parallelStream().map(ItemDto::new).collect(Collectors.toList());
    }

    public List<ItemDto> getItemsByUser(int userId) {

        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if(!userEntity.isPresent()) {
            return null;
        }
        List<ItemEntity> items = itemRepository.findByUser(userEntity.get());

        return items.parallelStream().map(ItemDto::new).collect(Collectors.toList());
    }

    @Override
    public ItemDto save(ItemDto itemDTo) {
        //1. Map to Entity
        ItemEntity item = itemMapper.toItemEntity(itemDTo);
        //2. Save
        item = this.itemRepository.save(item);
        //3. Map to Dto
        return new ItemDto(item);
    }

    public void delete(Long itemId) {

        this.itemRepository.deleteById(itemId);
    }


}
