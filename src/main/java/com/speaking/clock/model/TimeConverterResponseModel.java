package com.speaking.clock.model;

public class TimeConverterResponseModel {

    private String timeInWords;

    public TimeConverterResponseModel(String timeInWords){
        this.timeInWords=timeInWords;
    }

    public String getTimeInWords() {
        return timeInWords;
    }
}
