package com.ecommerce.bicicle.service.impl;

import com.ecommerce.bicicle.dto.ItemCategoryFilterDto;
import com.ecommerce.bicicle.dto.ItemFilterDto;
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
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
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

    @Autowired
    private EntityManager em;

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
    public List<ItemSavedDto> getFilteredItems(ItemFilterDto itemFilterDto) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ItemEntity> criteriaQ = cb.createQuery(ItemEntity.class);
        Root<ItemEntity> root = criteriaQ.from(ItemEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        //Search by name
        try {
            if(itemFilterDto.getSearchBar() != null && !itemFilterDto.getSearchBar().isEmpty()) {
                predicates.add(cb.equal(root.get("name"), itemFilterDto.getSearchBar()));
            }
        } catch (NullPointerException n) {

        }

        //Search by years
        try {
            if(itemFilterDto.getYears() != null && !itemFilterDto.getYears().isEmpty()) {
                predicates.add( cb.equal(root.get("year"), itemFilterDto.getYears()) );
            }
        } catch (NullPointerException n) {

        }

        //Search by Types
        try {
            if(itemFilterDto.getItemTypes() != null && !itemFilterDto.getItemTypes().isEmpty()) {
                List<String> typeIds = getSelectedTypes(itemFilterDto.getItemTypes());
                if(!typeIds.isEmpty()) {
                    predicates.add(cb.and(root.get("itemTypeCatId").in(typeIds) ) );
                }
            }
        } catch (NullPointerException n) {

        }

        Predicate[] predicateArray = new Predicate[predicates.size()];
        predicateArray = predicates.toArray(predicateArray);

        criteriaQ.select(root).where(predicateArray);

        List<ItemEntity> itemEntities = em.createQuery(criteriaQ).getResultList();

        List<ItemSavedDto> itemSavedDtos = itemSaveMapper.toItemSaveDtoList(itemEntities);

        return itemSavedDtos;
    }

    List<String> getSelectedTypes(List<ItemCategoryFilterDto> itemCategoryFilterDto) {

        List<String> typeIds = itemCategoryFilterDto.stream()
                .filter(category -> category.getIsSelected())
                .map(category -> category.getId() + "" ).collect(Collectors.toList());

        return typeIds;
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
