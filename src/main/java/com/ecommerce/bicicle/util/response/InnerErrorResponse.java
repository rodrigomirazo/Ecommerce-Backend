package com.ecommerce.bicicle.util.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InnerErrorResponse implements Serializable {

    private String error;
    private String exception;
    private List<String> userMessages;
    private List<String> stackTrace;

    public InnerErrorResponse() {
        this.userMessages = new ArrayList<String>();
        this.stackTrace = new ArrayList<String>();
    }

    public InnerErrorResponse(String error) {
        this.error = error;
        this.userMessages = new ArrayList<String>();
        this.stackTrace = new ArrayList<String>();
    }

    public InnerErrorResponse(String error, String exception) {
        this.error = error;
        this.exception = exception;
        this.userMessages = new ArrayList<String>();
        this.stackTrace = new ArrayList<String>();
    }

    public InnerErrorResponse(String error, String exception, List<String> stackTrace) {
        this.error = error;
        this.exception = exception;
        this.stackTrace = stackTrace;
        this.userMessages = new ArrayList<String>();
    }

    public InnerErrorResponse(String error, String exception, List<String> stackTrace, List<String> userMessages) {
        this.error = error;
        this.exception = exception;
        this.stackTrace = stackTrace;
        this.userMessages = userMessages;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return this.exception;
    }

    public List<String> getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(List<String> stackTrace) {
        this.stackTrace = stackTrace;
    }

    public List<String> getUserMessages() {
        return this.userMessages;
    }

    public void setUserMessages(List<String> userMessages) {
        this.userMessages = userMessages;
    }

    public void addUserMessage(String userMessage) {
        this.userMessages.add(userMessage);
    }

    public void addAllUserMessages(List<String> userMessages) {
        this.userMessages.addAll(userMessages);
    }

}