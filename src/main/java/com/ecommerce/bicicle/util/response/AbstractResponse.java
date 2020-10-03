package com.ecommerce.bicicle.util.response;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class AbstractResponse<T> implements Serializable {

    private HttpStatus status;
    private T responseBody;

    AbstractResponse() {
    }

    AbstractResponse(HttpStatus status, T responseBody) {
        this.status = status;
        this.responseBody = responseBody;
    }

    public int getStatus() {
        return status.value();
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public T getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(T responseBody) {
        this.responseBody = responseBody;
    }

}
