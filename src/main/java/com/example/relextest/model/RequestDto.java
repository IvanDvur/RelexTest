package com.example.relextest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RequestDto {
    String path;
    String operation;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "path='" + path + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }
}
