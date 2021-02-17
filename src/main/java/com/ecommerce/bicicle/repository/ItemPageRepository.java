package com.ecommerce.bicicle.repository;

import com.ecommerce.bicicle.entity.ItemEntity;
import com.ecommerce.bicicle.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Timestamp;
import java.util.List;

public interface ItemPageRepository extends PagingAndSortingRepository<ItemEntity, Integer> {

    List<ItemEntity> findByDiagnostApprovedAndCreatedTimeBetween(
            Boolean diagnostApproved, Timestamp createdTimeStart, Timestamp createdTimeEnd,
            Pageable pageable);

    //List<ItemEntity> findByDiagnostApprovedEqualsNullAndCreatedTimeBetween(
    //        Timestamp createdTimeStart, Timestamp createdTimeEnd, Pageable pageable);
}
