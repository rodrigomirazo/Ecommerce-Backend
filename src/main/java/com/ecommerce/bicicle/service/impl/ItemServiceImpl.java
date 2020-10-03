package com.ecommerce.bicicle.service.impl;

import com.ecommerce.bicicle.dto.ItemDTo;
import com.ecommerce.bicicle.entity.ItemEntity;
import com.ecommerce.bicicle.repository.ItemRepository;
import com.ecommerce.bicicle.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemDTo> get() {

        List<ItemEntity> items = StreamSupport.stream(
                itemRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return items.parallelStream().map(ItemDTo::new).collect(Collectors.toList());
    }

    public List<ItemDTo> getItemsByType(int itemTypeCatId) {

        List<ItemEntity> items = itemRepository.findByItemTypeCatId(itemTypeCatId);

        return items.parallelStream().map(ItemDTo::new).collect(Collectors.toList());
    }

    @Override
    public ItemDTo save(ItemDTo itemDTo) {
        //1. Map to Entity
        ItemEntity item = new ItemEntity(itemDTo);
        //2. Save
        item = this.itemRepository.save(item);
        //3. Map to Dto
        return new ItemDTo(item);
    }

    public void delete(Long itemId) {

        this.itemRepository.deleteById(itemId);
    }


}
