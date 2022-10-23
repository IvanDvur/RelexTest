package com.example.relextest.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RelexService {

    private List<String> stringsFromFile;

    // Создание коллекции из файла
    public List<Integer> createListFromFile(String url) {
        try {
            stringsFromFile = Files.readAllLines(new File(url).toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
        return stringsFromFile.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    // Поиск максимального значения
    public String getMaxValue(String url) {
        List<Integer> numbers = createListFromFile(url);
        return Collections.max(numbers).toString();
    }

    // Поиск минимального значения
    public String getMinValue(String url) {
        List<Integer> numbers = createListFromFile(url);
        return Collections.min(numbers).toString();
    }

    // Поиск медианного значения
    public String getMediane(String url) {
        List<Integer> numbers = createListFromFile(url);
        numbers.sort(Comparator.naturalOrder());
//      Если длина массива нечётная,возвращаем центральный элемент
        if (numbers.size() % 2 == 1) {
            Integer result = numbers.get(numbers.size() / 2);
            return result.toString();
//      Если длина массива чётная
        } else {
            Double result = 0.5 * (numbers.get(numbers.size() / 2 - 1) + numbers.get(numbers.size() - 1));
            return result.toString();
        }
    }

    // Поиск среднего значения
    public String getAverage(String url) {
        List<Integer> numbers = createListFromFile(url);
        Double average = numbers.stream().mapToDouble(d -> d).average().orElse(0.0);
        return average.toString();
    }

    // Поиск самой длинной(ых) возрастающих последовательностей
    public String getAscendingSequences(String url) {
        List<Integer> numbers = createListFromFile(url);
        try {
            List<List<Integer>> listOfList = new ArrayList<>();
            int count = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = count; j < numbers.size() - 1; j++) {
                if (numbers.get(j + 1) > numbers.get(j)) {
                    list = new ArrayList<>(list);
                    if (!list.contains(numbers.get(j))) {
                        list.add(numbers.get(j));
                    }
                    list.add(numbers.get(j + 1));
                } else {
                    list = new ArrayList<>();
                    count++;
                }
                if (!list.isEmpty()) {
                    listOfList.add(list);
                }
            }
            int highestListSize = listOfList.stream().mapToInt(List::size).max()
                    .getAsInt();
            return listOfList.stream().filter(x -> x.size() == highestListSize)
                    .collect(Collectors.toList()).toString();
        } catch (NoSuchElementException e) {
            return "No ascending sequences";
        }
    }

    // Поиск самой длинной(ых) убывающих последовательностей
    public String getDescendingSequences(String url) {
        List<Integer> numbers = createListFromFile(url);
        try {
            List<List<Integer>> listOfList = new ArrayList<>();
            int count = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = count; j < numbers.size() - 1; j++) {
                if (numbers.get(j + 1) < numbers.get(j)) {
                    list = new ArrayList<>(list);
                    if (!list.contains(numbers.get(j))) {
                        list.add(numbers.get(j));
                    }
                    list.add(numbers.get(j + 1));
                } else {
                    list = new ArrayList<>();
                    count++;
                }
                if (!list.isEmpty()) {
                    listOfList.add(list);
                }
            }
            int highestListSize = listOfList.stream().mapToInt(List::size).max()
                    .getAsInt();
            return listOfList.stream().filter(x -> x.size() == highestListSize)
                    .collect(Collectors.toList()).toString();
        } catch (NoSuchElementException e) {
            return "No ascending sequences";
        }
    }
}
