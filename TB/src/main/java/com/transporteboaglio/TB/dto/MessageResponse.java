package com.transporteboaglio.TB.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageResponse {
    private List<String> message;
    private Integer Status;
    private Date timeStamp;

    public MessageResponse(Integer status) {
        this.Status=status;
        this.message = new ArrayList<>();
        this.timeStamp = new Date();
    }

    public MessageResponse(Integer status, String message) {
        Status = status;
        this.message = new ArrayList<>();
        this.message.add(message);
        this.timeStamp = new Date();
    }

    public MessageResponse() {
    }

    public MessageResponse(List<String> message, Integer status, Date timeStamp) {
        this.message = message;
        Status = status;
        this.timeStamp = timeStamp;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}