package com.example.relextest.model;

public class RequestDto {

    private String path;
    private String operation;

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
