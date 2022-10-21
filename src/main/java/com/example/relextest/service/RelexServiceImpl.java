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
    public String getMaxValue(String url) {
        List<Integer> numbers = createListFromFile(url);
        return Collections.max(numbers).toString();
    }


    //    Поиск минимального значения
    public String getMinValue(String url) {
        List<Integer> numbers = createListFromFile(url);
        return Collections.min(numbers).toString();
    }


    // Поиск медианного значения
    public String getMediane(String url) {
        List<Integer> numbers = createListFromFile(url);
        numbers.sort(Comparator.naturalOrder());
        if (numbers.size() % 2 == 1) {
            return Double.valueOf(numbers.get(numbers.size() / 2)).toString();
        } else {
            var result=(numbers.get((numbers.size() / 2) - 1) + numbers.get(numbers.size() / 2)) / 2;
            return  Double.valueOf(result).toString();
        }
    }

    //   Поиск среднего значения
    public String getAverage(String url) {
        List<Integer> numbers = createListFromFile(url);
        Double average = numbers.stream().mapToDouble(d -> d).average().orElse(0.0);
        return average.toString();
    }

    // Поиск самой длинной(ых) возрастающих последовательностей
    public List<List<Integer>> getAscendingSequences(String url) {
        List<Integer> numbers = createListFromFile(url);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> longestArray = new ArrayList<>();
        List<Integer> currentArray = new ArrayList<>();
        for (int i = 1; i < numbers.size(); i++) {
            if (currentArray.isEmpty()) {
                currentArray.add(numbers.get(i - 1));
            }
            if (numbers.get(i) > numbers.get(i - 1)) {
                currentArray.add(numbers.get(i));
            }
            else {
                if (longestArray.size() < currentArray.size()) {
                    longestArray.clear();
                    longestArray.addAll(currentArray);
                    results.add(longestArray);
                }
                currentArray.clear();
            }
        }
        return results;
    }

    //    Поиск самой длинной(ых) возрастающих последовательностей
//    public List<List<Integer>> getDescendingSequences(String url) {
//        List<Integer> numbers = createListFromFile(url);
//        List<List<Integer>> results = new ArrayList<>();
//        List<Integer> longestArray = new ArrayList<>();
//        List<Integer> currentArray = new ArrayList<>();
//        for (int i = 1; i < numbers.size(); i++) {
//            if (currentArray.isEmpty()) {
//                currentArray.add(numbers.get(i - 1));
//            }
//            if (numbers.get(i) < numbers.get(i - 1)) {
//                currentArray.add(numbers.get(i));
//            }
//            else {
//                if (longestArray.size() < currentArray.size()) {
//                    longestArray.clear();
//                    longestArray.addAll(currentArray);
//                    results.add();
//                }
//                currentArray.clear();
//            }
//        }
//        return results;
//    }
}
