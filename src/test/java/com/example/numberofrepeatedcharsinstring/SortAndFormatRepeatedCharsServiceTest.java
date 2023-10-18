package com.example.numberofrepeatedcharsinstring;

import com.example.numberofrepeatedcharsinstring.service.SortAndFormatRepeatedCharsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class SortAndFormatRepeatedCharsServiceTest {

    @InjectMocks
    private SortAndFormatRepeatedCharsService sortAndFormatRepeatedCharsService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    private static final Map<Character, Integer> CHARS_TO_QUANTITY = new HashMap<>();

    static {
        CHARS_TO_QUANTITY.put('c', 1);
        CHARS_TO_QUANTITY.put('b', 2);
        CHARS_TO_QUANTITY.put('a', 3);
    }

    @Test
    void assertSortAndFormatResultReturnsLinkedHashMap() {
        Map<Character, Integer> sortedCharsToQuantity = sortAndFormatRepeatedCharsService.sortAndFormatResult(CHARS_TO_QUANTITY);

        Assertions.assertNotNull(sortedCharsToQuantity);

        Assertions.assertTrue(sortedCharsToQuantity instanceof LinkedHashMap<Character, Integer>);
    }


    @Test
    void assertGetSortedCharsReturnsLinkedHashMapWithCorrectOrder() {
        Map<Character, Integer> sortedCharsToQuantity = sortAndFormatRepeatedCharsService.sortAndFormatResult(CHARS_TO_QUANTITY);

        Assertions.assertNotNull(sortedCharsToQuantity);

        Iterator<Map.Entry<Character, Integer>> iterator = sortedCharsToQuantity.entrySet().iterator();

        Assertions.assertEquals('a', (char) iterator.next().getKey());
        Assertions.assertEquals('b', (char) iterator.next().getKey());
        Assertions.assertEquals('c', (char) iterator.next().getKey());
    }

    @Test
    void assertGetSortedCharsReturnsEmptyLinkedHashWhenIncomingMapIsEmpty() {
        Map<Character, Integer> sortedCharsToQuantity = sortAndFormatRepeatedCharsService.sortAndFormatResult(new HashMap<>());

        Assertions.assertEquals(0, sortedCharsToQuantity.size());

    }

    @Test
    void assertGetSortedCharsThrowsNullPointerExceptionWhenNullIsPassedToArgument() {
        Assertions.assertThrows(NullPointerException.class, () -> sortAndFormatRepeatedCharsService.sortAndFormatResult(null));
    }

}
