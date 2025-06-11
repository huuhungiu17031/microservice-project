package com.ecommerce.commonlib.exception;

import com.ecommerce.commonlib.utils.MessageUtil;

public class NotFoundException extends RuntimeException {
    private final String message;

    public NotFoundException(String errorCode, Object... extra) {
        this.message =  MessageUtil.getMessage(errorCode, extra);
    }

    @Override
    public String getMessage() {
        return message;
    }
}