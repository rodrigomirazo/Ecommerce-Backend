package com.ecommerce.bicicle.service.impl;

import com.ecommerce.bicicle.dto.*;
import com.ecommerce.bicicle.entity.ItemEntity;
import com.ecommerce.bicicle.entity.ItemFloatingCharsRelEntity;
import com.ecommerce.bicicle.entity.UserEntity;
import com.ecommerce.bicicle.mapper.ItemMapper;
import com.ecommerce.bicicle.mapper.ItemSaveFloatingCharsMapper;
import com.ecommerce.bicicle.mapper.ItemSaveMapper;
import com.ecommerce.bicicle.repository.ItemEntityRepository;
import com.ecommerce.bicicle.repository.ItemFloatingCharsRelRepository;
import com.ecommerce.bicicle.repository.ItemPageRepository;
import com.ecommerce.bicicle.repository.UserRepository;
import com.ecommerce.bicicle.service.FloatingCharsService;
import com.ecommerce.bicicle.service.ItemService;
import com.ecommerce.bicicle.service.UserService;
import com.ecommerce.bicicle.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemEntityRepository itemRepository;

    @Autowired
    private ItemPageRepository itemPageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemFloatingCharsRelRepository itemFloatingCharsRelRepository;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemSaveMapper itemSaveMapper;

    @Autowired
    private ItemSaveFloatingCharsMapper floatingCharsMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private FloatingCharsService floatingCharsService;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Override
    public List<ItemSavedDto> get() {

        List<ItemEntity> items = StreamSupport.stream(
                itemRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return itemSaveMapper.toItemSaveDtoList(items);
    }

    @Override
    public List<ItemSavedDto> getItemsByType(int itemTypeCatId) {

        List<ItemEntity> items = itemRepository.findByItemTypeCatId(itemTypeCatId);

        return itemSaveMapper.toItemSaveDtoList(items);
    }

    @Override
    public List<ItemSavedDto> getItemsToApprovedOrRejected(
            Boolean diagnostApproved, Timestamp createdTimeStart, Timestamp createdTimeEnd, Integer pageNum, Integer pageSize) {

        Pageable page = PageRequest.of(pageNum, pageSize);
        List<ItemEntity> items = itemPageRepository.findByDiagnostApprovedAndCreatedTimeBetweenAndPriceGreaterThan(
                diagnostApproved, createdTimeStart, createdTimeEnd, 0
        );

        List<ItemSavedDto> itemSavedDtosList = floatingCharsMapper.toItemSaveDtoList(items);

        /*
        PagedListHolder pageHold = new PagedListHolder(itemSavedDtosList);
        pageHold.setPageSize(items.getSize()); // number of items per page
        pageHold.setPage(items.getPageable().getPageNumber());
        pageHold.setMaxLinkedPages(items.getTotalPages());
*/
        return itemSavedDtosList;
    }

    @Override
    public List<ItemSavedDto> getItemsNotYetApproved(
            Timestamp createdTimeStart, Timestamp createdTimeEnd, Integer pageNum, Integer pageSize) {

        Pageable page = PageRequest.of(pageNum, pageSize);
        List<ItemEntity> items = itemPageRepository.findByDiagnostApprovedAndCreatedTimeBetweenAndPriceGreaterThan(null,
                createdTimeStart, createdTimeEnd, 0
        );

        List<ItemSavedDto> itemSavedDtosList = floatingCharsMapper.toItemSaveDtoList(items);
/*
        PagedListHolder pageHold = new PagedListHolder(itemSavedDtosList);
        pageHold.setPageSize(items.getSize()); // number of items per page
        pageHold.setPage(items.getPageable().getPageNumber());
        pageHold.setMaxLinkedPages(items.getTotalPages());
*/
        return itemSavedDtosList;
    }

    @Override
    public ItemSavedDto itemSavedDiagnost(Integer itemId, Boolean passed, String comments) {

        Optional<ItemEntity> itemEntity = itemRepository.findById(itemId);

        itemEntity.get().getItemFloatingCharsRel();

        if(!itemEntity.isPresent()) {
            return null;
        }

        ItemEntity item = itemEntity.get();
        item.setDiagnostApproved(passed);
        item.setDiagnostTime(getTimeStamp());
        item.setDiagnostComments(comments);

        item = itemRepository.save(item);

        ItemSavedDto itemSavedDto = floatingCharsMapper.toItemSaveDto(item);
        return itemSavedDto;
    }

    @Override
    public List<ItemSavedDto> getFilteredItems(ItemFilterDto itemFilterDto) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ItemEntity> criteriaQ = cb.createQuery(ItemEntity.class);
        Root<ItemEntity> root = criteriaQ.from(ItemEntity.class);
        List<Predicate> predicates = new ArrayList<>();

        Map<Integer, List<Integer>> requestedFloatingChars = new HashMap<>();

        try {
            for (int i = 0; i < itemFilterDto.getItemFloatingChars().size(); i++) {

                List<Integer> filterCahrsDtos =
                        itemFilterDto.getItemFloatingChars()
                                .get(i).getCatalogList().stream()
                                .filter(floatCatalog -> floatCatalog.getIsSelected())
                                .map(floatCatalog -> floatCatalog.getCharId())
                                .collect(Collectors.toList());

                if (!filterCahrsDtos.isEmpty()) {
                    requestedFloatingChars.put(itemFilterDto.getItemFloatingChars().get(i).getFloatingCharId(),
                            filterCahrsDtos);
                }
            }
        } catch (NullPointerException e) {

        }

        //Filter approved only
        predicates.add(cb.equal(root.get("diagnostApproved"), true));

        //Filter not Bought items
        predicates.add(cb.equal(root.get("paymentConfirmed"), false));

        predicates.add(cb.equal(root.get("itemTransactionId"), 0));

        //Search by name
        try {
            if(itemFilterDto.getSearchBar() != null && !itemFilterDto.getSearchBar().isEmpty()) {
                predicates.add(cb.like(root.get("model"), "%"+itemFilterDto.getSearchBar() + "%"));
            }
        } catch (NullPointerException n) {

        }

        //Search by years
        try {
            if(itemFilterDto.getYears() != null && !itemFilterDto.getYears().isEmpty()) {
                List<Integer> years =
                itemFilterDto.getYears().stream()
                        .filter(itemFilterYearsDto -> itemFilterYearsDto.getIsSelected())
                        .map(itemFilterYearsDto -> itemFilterYearsDto.getYear())
                        .collect(Collectors.toList());

                if(!years.isEmpty())
                    predicates.add( cb.and(root.get("year").in(years)) );
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

        List<ItemEntity> itemEntities = em
                .createQuery(criteriaQ)
                .getResultList();
        List<ItemSavedDto> itemSavedDtos = itemSaveMapper.toItemSaveDtoList(itemEntities);

        // No Floating Chars selected
        if(requestedFloatingChars.size() == 0) {
            return itemSavedDtos;
        }

        //Obtain Flaoting Chars
        List<ItemSavedDto> itemsFilter = new ArrayList<>();
        itemSavedDtos.forEach(itemSavedDto -> {

            for (FloatingCharsRelDto itemFloatingChar : itemSavedDto.getItemFloatingChars()) {
                // Example Item is made of CARBON
                Integer itemFloatAssign = itemFloatingChar.getFloatingCharCatId();

                // Example: Aluminium, CARBON (from Filter)
                List<Integer> floatCharsFilterSelected = requestedFloatingChars.get(itemFloatingChar.getFloatingCharId());

                if(floatCharsFilterSelected != null && floatCharsFilterSelected.contains(itemFloatAssign)) {
                    itemsFilter.add(itemSavedDto);
                    break;
                }
            }
        });

        itemsFilter.stream().sorted((o1, o2) -> o1.getCreatedTime().compareTo(o2.getCreatedTime()));

        return itemsFilter;
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

        return items.parallelStream().map(item -> itemSaveMapper.toItemSaveDto(item)).collect(Collectors.toList());
    }

    @Override
    public ItemSavedDto getItemsById(int itemId) {

        Optional<ItemEntity> itemEntity = itemRepository.findById(itemId);

        itemEntity.get().getItemFloatingCharsRel();

        if(!itemEntity.isPresent()) {
            return null;
        }
        ItemSavedDto itemSavedDto = itemSaveMapper.toItemSaveDto(itemEntity);

        return itemSavedDto;
    }

    @Override
    public ItemSavedDto save(ItemSavedDto itemDTo, Integer userId) {

        UserDto user = userService.get(userId);
        itemDTo.setUser(user);

        //1. Map to Entity
        ItemEntity item = itemSaveMapper.toItemEntity(itemDTo);
        //2. Save
        item.setCreatedTime(getTimeStamp());
        item = this.itemRepository.save(item);

        List<FloatingCharsRelDto> floatingCharsRelated = itemDTo.getItemFloatingChars();

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
        if( item.getRuedosRate() > 0) {
            emailService.sendUploadItemNotification(itemDTo);
        }
        return itemSaveMapper.toItemSaveDto(item);
    }

    @Override
    public void delete(Integer itemId) {

        try {
            this.itemRepository.deleteById(itemId);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("already deleted");
        }
    }

    private Timestamp getTimeStamp() {

        Calendar cal = Calendar.getInstance();
        return new Timestamp(cal.toInstant().toEpochMilli());
    }

}
