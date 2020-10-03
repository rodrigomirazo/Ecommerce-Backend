package com.ecommerce.bicicle.util.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MessageResolverImpl implements MessageResolver {

    @Autowired
    private MessageSource messageSource;

    @Override
    public String getMessage(String code) {
        return messageSource.getMessage(code, new Object[]{}, LocaleContextHolder.getLocale());
    }

    @Override
    public String getMessage(String code, @Nullable Object[] params) {
        return messageSource.getMessage(code, params, LocaleContextHolder.getLocale());
    }
}