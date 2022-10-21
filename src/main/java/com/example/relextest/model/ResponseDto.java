package com.example.relextest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResponseDto {

    String result;

    public ResponseDto(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
