package com.example.numberofrepeatedcharsinstring.service;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Сервисный класс для подсчета повторяющихся символов во входной строке и
 * представления результатов в виде карты.
 */
@Service
public class CountRepeatedCharsService {

    /**
     * Метод подсчитывающий количество вхождений каждого символа в заданной строке и возвращий
     * результат.
     *
     * @param inputString Входная строка для анализа.
     * @return Карта символов и их повторений.     *
     * @see SortAndFormatRepeatedCharsService#sortAndFormatResult(Map)
     */
    public Map<Character, Integer> getCharsCount(String inputString) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < inputString.length(); i++) {
            if (!map.containsKey(inputString.charAt(i))) {
                map.put(inputString.charAt(i), 1);
            } else {
                map.put(inputString.charAt(i), map.get(inputString.charAt(i)) + 1);
            }
        }
        return map;
    }
}
