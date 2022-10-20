package com.example.relextest.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface RelexService {
    Integer getMaxValue(String url) throws IOException;
    Integer getMinValue(String url) throws IOException;
    Integer getMediane(String url);
    Double getAverage(String url);
    ArrayList<Integer[]> getAscendingSequences(String url);
    ArrayList<Integer[]> getDescendingSequences(String url);
}
