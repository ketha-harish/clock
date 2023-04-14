package com.speaking.clock.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponseModel {
    private String statusCode;
    private String message;

    private Object data;

    public CommonResponseModel(String statusCode,String message){
        this.statusCode=statusCode;
        this.message=message;
    }

    public CommonResponseModel(String statusCode,String message,Object data){
        this.statusCode=statusCode;
        this.message=message;
        this.data=data;
    }



    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
