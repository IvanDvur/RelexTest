package com.example.relextest.model;

import java.util.ArrayList;

public class FullResponceDto {

    private String max_value;
    private String min_value;
    private String average;
    private String mediane;
    private String ascendingSequences;
    private String descendingSequences;

    public FullResponceDto(ArrayList<String> values) {
        this.max_value = values.get(0);
        this.min_value = values.get(1);
        this.average = values.get(2);
        this.mediane = values.get(3);
        this.ascendingSequences = values.get(4);
        this.descendingSequences = values.get(5);
    }

    public String getMax_value() {
        return max_value;
    }

    public void setMax_value(String max_value) {
        this.max_value = max_value;
    }

    public String getMin_value() {
        return min_value;
    }

    public void setMin_value(String min_value) {
        this.min_value = min_value;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getMediane() {
        return mediane;
    }

    public void setMediane(String mediane) {
        this.mediane = mediane;
    }

    public String getAscendingSequences() {
        return ascendingSequences;
    }

    public void setAscendingSequences(String ascendingSequences) {
        this.ascendingSequences = ascendingSequences;
    }

    public String getDescendingSequences() {
        return descendingSequences;
    }

    public void setDescendingSequences(String descendingSequences) {
        this.descendingSequences = descendingSequences;
    }

    @Override
    public String toString() {
        return "FileResponceDto{" +
                "max_value='" + max_value + '\'' +
                ", min_value='" + min_value + '\'' +
                ", average='" + average + '\'' +
                ", mediane='" + mediane + '\'' +
                ", ascendingSequences='" + ascendingSequences + '\'' +
                ", descendingSequences='" + descendingSequences + '\'' +
                '}';
    }
}
