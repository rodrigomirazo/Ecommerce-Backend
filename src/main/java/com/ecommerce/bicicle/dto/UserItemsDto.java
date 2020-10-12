package com.ecommerce.bicicle.dto;

import java.util.List;

public class UserItemsDto {

    private UserDto user;
    private List<ItemDto> itemDtos;

    public UserItemsDto() {
    }

    public UserDto getUser() {
        return user;
    }

    public UserItemsDto setUser(UserDto user) {
        this.user = user;
        return this;
    }

    public List<ItemDto> getItemDtos() {
        return itemDtos;
    }

    public UserItemsDto setItemDtos(List<ItemDto> itemDtos) {
        this.itemDtos = itemDtos;
        return this;
    }
}
