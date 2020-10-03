package com.ecommerce.bicicle.util.response;

import org.springframework.http.HttpStatus;

import java.util.List;

final public class ErrorResponse extends AbstractResponse<InnerErrorResponse> {

    public ErrorResponse() {
        super();
    }

    public ErrorResponse(HttpStatus status) {
        super(status, new InnerErrorResponse(status.name()));
    }

    public ErrorResponse(HttpStatus status, String exception) {
        super(status, new InnerErrorResponse(status.name(), exception));
    }

    public ErrorResponse(HttpStatus status, String exception, List<String> stackTrace) {
        super(status, new InnerErrorResponse(status.name(), exception, stackTrace));
    }

    public ErrorResponse(HttpStatus status, String exception, List<String> stackTrace, List<String> messages) {
        super(status, new InnerErrorResponse(status.name(), exception, stackTrace, messages));
    }

}
