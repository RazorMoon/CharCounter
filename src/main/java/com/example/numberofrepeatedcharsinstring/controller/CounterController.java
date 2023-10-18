package com.example.numberofrepeatedcharsinstring.controller;

import static com.example.numberofrepeatedcharsinstring.constants.ExceptionMessages.WORD_CHARACTER_EXCEPTION;
import static com.example.numberofrepeatedcharsinstring.constants.RegularExpression.WORD_CHARACTER_REGEXP;

import com.example.numberofrepeatedcharsinstring.service.CharService;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * Контроллер, обеспечивающий обработку HTTP-запросов.
 *
 * Данный контроллер предоставляет методы для обработки HTTP-запросов, связанных с подсчетом
 * повторяющихся символов во входной строке.
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class CounterController {
    private final CharService charService;

    /**
     * Обрабатывает GET-запросы для подсчета количества символов во входной строке.
     *
     * Метод принимает входную строку из переменной запроса, выполняет подсчет символов в строке,
     * и возвращает результат в виде карты, где ключами являются уникальные символы,
     * а значениями - количество их вхождений во входной строке.
     *
     * @param inputString Входная строка для анализа. Должна содержать только слова (буквы и цифры).
     * @return ResponseEntity, содержащий карту, представляющую результат подсчета символов во входной строке.
     */
    @GetMapping("count/")
    public ResponseEntity<Map<Character, Integer>> getResult(
            @RequestParam
            @Pattern(regexp = WORD_CHARACTER_REGEXP,
            message = WORD_CHARACTER_EXCEPTION + WORD_CHARACTER_REGEXP) String inputString) {

        Map<Character, Integer> map = charService.getCharacterSortedByQuantity(inputString);
        return ResponseEntity.ok(map);
    }
}

