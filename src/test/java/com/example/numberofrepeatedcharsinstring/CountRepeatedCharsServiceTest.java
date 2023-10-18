package com.example.numberofrepeatedcharsinstring;

import com.example.numberofrepeatedcharsinstring.service.CountRepeatedCharsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Map;

class CountRepeatedCharsServiceTest {

    @InjectMocks
    private CountRepeatedCharsService countRepeatedCharsService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void assertThatGetCharsCountWorksCorrect() {
        Map<Character, Integer> charsToQuantity = countRepeatedCharsService.getCharsCount("world");

        Assertions.assertEquals(5, charsToQuantity.size());

        Assertions.assertEquals(1, charsToQuantity.get('w'));
        Assertions.assertEquals(1, charsToQuantity.get('o'));
        Assertions.assertEquals(1, charsToQuantity.get('r'));
        Assertions.assertEquals(1, charsToQuantity.get('l'));
        Assertions.assertEquals(1, charsToQuantity.get('d'));
    }

    @Test
    void assertThatGetCharsCountWorksCorrectWithDuplicates() {
        Map<Character, Integer> charsToQuantity = countRepeatedCharsService.getCharsCount("abccab");
        Assertions.assertEquals(3, charsToQuantity.size());

        Assertions.assertEquals(2, charsToQuantity.get('a'));
        Assertions.assertEquals(2, charsToQuantity.get('b'));
        Assertions.assertEquals(2, charsToQuantity.get('c'));
    }

    @Test
    void assertThatGetCountedCharsReturnsEmptyHashMapWhenPhraseIsEmpty() {
        Map<Character, Integer> charsToQuantity = countRepeatedCharsService.getCharsCount("");

        Assertions.assertEquals(0, charsToQuantity.size());
    }

    @Test
    void assertThatGetCountedCharsThrowsNullPointerExceptionWhenNullIsPassedToArgument() {
        Assertions.assertThrows(NullPointerException.class, () -> countRepeatedCharsService.getCharsCount(null));
    }
}
