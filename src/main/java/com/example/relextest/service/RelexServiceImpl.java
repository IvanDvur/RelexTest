package com.example.relextest.service;


import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelexServiceImpl implements RelexService {

    private List<String> fileNumbers;
//    Поиск максимального значения
    @Override
    public Integer getMaxValue(String url) {
        try {
            fileNumbers = Files.readAllLines(Path.of(url));
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
        List<Integer> numbers = fileNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
        return Collections.max(numbers);
    }

//    Поиск минимального значения
    @Override
    public Integer getMinValue(String url) {
        try {
            List<String> fileNumbers = Files.readAllLines(new File(url).toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
        List<Integer> numbers = fileNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
        return Collections.min(numbers);
    }

    @Override
    public Integer getMediane(String url) {
        return null;
    }

    @Override
    public Double getAverage(String url) {
        return null;
    }

    @Override
    public ArrayList<Integer[]> getAscendingSequences(String url) {
        return null;
    }

    @Override
    public ArrayList<Integer[]> getDescendingSequences(String url) {
        return null;
    }


}
