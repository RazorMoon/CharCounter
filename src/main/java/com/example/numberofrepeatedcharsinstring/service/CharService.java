package com.example.numberofrepeatedcharsinstring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
/**
 * Сервисный класс для обработки символов во входной строке.
 * Использует два внедренных сервиса для подсчета повторяющихся символов и сортировки и форматирования результатов.
 */
@Service
@RequiredArgsConstructor
public class CharService {
    private final CountRepeatedCharsService countRepeatedCharsService;
    private final SortAndFormatRepeatedCharsService sortAndFormatRepeatedCharsService;

    /**
     * Получает входную строку, выполняет подсчет повторяющихся символов и
     * возвращает результат в виде карты, отсортированной по количеству символов.
     *
     * @param inputString Входная строка для анализа.
     * @return Карта, представляющая результат подсчета и отсортированную по количеству символов.
     */
    public Map<Character, Integer> getCharacterSortedByQuantity(String inputString) {
        Map<Character, Integer> map = countRepeatedCharsService.getCharsCount(inputString);
        return sortAndFormatRepeatedCharsService.sortAndFormatResult(map);
    }
}
