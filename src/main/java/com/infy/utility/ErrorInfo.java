package com.infy.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorInfo {
    private String errorMessage;
    private Integer errorCode;
    private LocalDateTime timeStamp;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public LocalDateTime getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
