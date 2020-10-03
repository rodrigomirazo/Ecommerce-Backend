package com.ecommerce.bicicle.util.response;

import org.springframework.http.HttpStatus;

public class SuccessResponse<T> extends AbstractResponse<T> {

    private static final long serialVersionUID = -411789513841317291L;
    private String userMessage;

    public SuccessResponse() {
    }

    public SuccessResponse(T responseBody) {
        super(HttpStatus.OK, responseBody);
    }

    public SuccessResponse(T responseBody, String userMessage) {
        super(HttpStatus.OK, responseBody);
        this.userMessage = userMessage;
    }

    public SuccessResponse(HttpStatus status, T responseBody, String userMessage) {
        super(status, responseBody);
        this.userMessage = userMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

}
