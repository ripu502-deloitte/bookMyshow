package com.bookmyshow.bookmyshow.dto;

public class EpochResponse {

    private Long timeStamp;
    private String port;

    public EpochResponse() {
    }

    public EpochResponse(Long timeStamp, String port) {
        this.timeStamp = timeStamp;
        this.port = port;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public String getPort() {
        return port;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
