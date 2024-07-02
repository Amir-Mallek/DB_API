package com.amir.dbApi.oerations.response;

import java.time.LocalDateTime;

public class DbResponse {
    private String status;
    private LocalDateTime timestamp;
    private String message;

    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL = "FAIL";

    public DbResponse(String status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
