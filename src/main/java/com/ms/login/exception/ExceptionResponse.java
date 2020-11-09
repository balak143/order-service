package com.ms.login.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private String error;
    private String endpoint;


    private HttpStatus status;

    public ExceptionResponse(Date timestamp, String message, String api, HttpStatus status) {
        super();
        this.timestamp = timestamp;
        this.error = message;
        this.status = status;
        this.endpoint = api;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }

    public String getEndpoint() {
        return endpoint;
    }
    public String getStatus() {
        return status.getReasonPhrase();
    }

}