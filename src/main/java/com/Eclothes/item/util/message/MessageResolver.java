package com.Eclothes.item.util.message;

public interface MessageResolver {
    String getMessage(String code);

    String getMessage(String code, Object[] params);
}