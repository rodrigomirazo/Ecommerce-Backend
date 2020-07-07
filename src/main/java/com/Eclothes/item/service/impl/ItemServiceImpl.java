package com.Eclothes.item.service.impl;

import com.Eclothes.item.dto.ItemDTo;
import com.Eclothes.item.entity.Item;
import com.Eclothes.item.entity.ItemTypeCat;
import com.Eclothes.item.repository.ItemRepository;
import com.Eclothes.item.service.ItemService;
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

        List<Item> items = StreamSupport.stream(
                itemRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return items.parallelStream().map(ItemDTo::new).collect(Collectors.toList());
    }

    public List<ItemDTo> getItemsByType(int itemTypeCatId) {

        List<Item> items = itemRepository.findByItemTypeCatId(itemTypeCatId);

        return items.parallelStream().map(ItemDTo::new).collect(Collectors.toList());
    }

    @Override
    public ItemDTo save(ItemDTo itemDTo) {
        //1. Map to Entity
        Item item = new Item(itemDTo);
        //2. Save
        item = this.itemRepository.save(item);
        //3. Map to Dto
        return new ItemDTo(item);
    }

    public void delete(Long itemId) {

        this.itemRepository.deleteById(itemId);
    }


}
