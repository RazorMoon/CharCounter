package com.example.numberofrepeatedcharsinstring;


import com.example.numberofrepeatedcharsinstring.service.CharService;
import com.example.numberofrepeatedcharsinstring.service.CountRepeatedCharsService;
import com.example.numberofrepeatedcharsinstring.service.SortAndFormatRepeatedCharsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class CharsServiceTest {

    @Mock
    private CountRepeatedCharsService countRepeatedCharsService;

    @Mock
    private SortAndFormatRepeatedCharsService sortAndFormatRepeatedCharsService;

    @InjectMocks
    private CharService charService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void assertThatGetCharsSortedByQuantityWorksFine() {
        String phrase = "hello";

        Map<Character, Integer> charsToQuantity = new HashMap<>();
        charsToQuantity.put('h', 1);
        charsToQuantity.put('e', 1);
        charsToQuantity.put('l', 2);
        charsToQuantity.put('o', 1);

        Mockito.when(countRepeatedCharsService.getCharsCount(phrase)).thenReturn(charsToQuantity);
        Mockito.when(sortAndFormatRepeatedCharsService.sortAndFormatResult(charsToQuantity)).thenReturn(new LinkedHashMap<>(charsToQuantity));

        Map<Character, Integer> sortedCharsByQuantity = charService.getCharacterSortedByQuantity(phrase);

        Assertions.assertEquals(4, charsToQuantity.size());

        Assertions.assertEquals(2, sortedCharsByQuantity.get('l'));
        Assertions.assertEquals(1, sortedCharsByQuantity.get('h'));
        Assertions.assertEquals(1, sortedCharsByQuantity.get('e'));
        Assertions.assertEquals(1, sortedCharsByQuantity.get('o'));
    }
}
