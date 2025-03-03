package com.devsuperior.dscatalog.resources.exceptions;

import java.time.Instant;

public class StandardError {

    private Instant timestap;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError() {

    }

    public StandardError(Instant timestap, Integer status, String error, String message, String path) {
        this.timestap = timestap;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Instant getTimestap() {
        return timestap;
    }

    public void setTimestap(Instant timestap) {
        this.timestap = timestap;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
