package com.example.relextest.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelexServiceImpl {

    private List<String> fileNumbers;

    //  Создание коллекции из файла
    public List<Integer> createListFromFile(String url) {
        try {
            fileNumbers = Files.readAllLines(new File(url).toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
        return fileNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    //    Поиск максимального значения
    public Integer getMaxValue(String url) {
        List<Integer> numbers = createListFromFile(url);
        return Collections.max(numbers);
    }

    //    Поиск минимального значения
    public Integer getMinValue(String url) {
        List<Integer> numbers = createListFromFile(url);
        return Collections.min(numbers);
    }

    // Поиск медианного значения
    public Double getMediane(String url) {
        List<Integer> numbers = createListFromFile(url);
        numbers.sort(Comparator.naturalOrder());

        System.out.println(numbers.size());
        if (numbers.size() % 2 == 1) {
            return Double.valueOf(numbers.get(numbers.size() / 2));
        } else
            return (double) ((numbers.get((numbers.size() / 2) - 1) + numbers.get(numbers.size() / 2)) / 2);

    }

    //   Поиск среднего значения
    public Double getAverage(String url) {
        List<Integer> numbers = createListFromFile(url);
        return numbers.stream().mapToDouble(d -> d).average().orElse(0.0);
    }

    // Поиск самой длинной(ых) возрастающих последовательностей
    public List<Integer> getAscendingSequences(String url) {
        List<Integer> numbers = createListFromFile(url);
        List<Integer> longestArray = new ArrayList<>();
        List<Integer> currentArray = new ArrayList<>();
        for (int i = 1; i < numbers.size(); i++) {
            if (currentArray.isEmpty()) {
                currentArray.add(numbers.get(i - 1));
            }
            if (numbers.get(i) > numbers.get(i - 1)) {
                currentArray.add(numbers.get(i));
            } else {
                if (longestArray.size() < currentArray.size()) {
                    longestArray.clear();
                    longestArray.addAll(currentArray);
                }
                currentArray.clear();
            }
        }
        return longestArray;
    }

    //    Поиск самой длинной(ых) возрастающих последовательностей
    public ArrayList<Integer[]> getDescendingSequences(String url) {
        return null;
    }
}
