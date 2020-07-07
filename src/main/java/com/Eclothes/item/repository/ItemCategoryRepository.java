package com.Eclothes.item.repository;

import com.Eclothes.item.entity.ItemCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ItemCategoryRepository extends CrudRepository<ItemCategory, Long> {
}
