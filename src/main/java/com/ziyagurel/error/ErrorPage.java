package com.ziyagurel.error;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ErrorPage {
    int status;
    String message;
    long timeStamp;
    String path;
    Map<String,String> validationError = new HashMap<>();

    public ErrorPage(int status, String message, String path){
        super();
        this.status = status;
        this.message = message;
        this.timeStamp = new Date().getTime();
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getValidationError() {
        return validationError;
    }

    public void setValidationError(Map<String, String> validationError) {
        this.validationError = validationError;
    }

}
