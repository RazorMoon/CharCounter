package com.example.numberofrepeatedcharsinstring.service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
    /**
    * Сервисный класс осуществляющий сортировку карты.
    *
    *
    **/
@Service
public class SortAndFormatRepeatedCharsService {
    /**
     * Метод, выполняющий сортировку карты символов и их повторений.
     *
     * @param frequencyMap Карта символов и их повторений.
     * @return Отсортированная карта символов по убыванию частоты.
     */
    public Map<Character, Integer> sortAndFormatResult(Map<Character, Integer> frequencyMap) {
        return frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
