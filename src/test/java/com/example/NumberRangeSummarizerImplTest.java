package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

class NumberRangeSummarizerImplTest {

    private NumberRangeSummarizer summarizer;

    @BeforeEach
    void setUp() {
        summarizer = new NumberRangeSummarizerImpl();
    }

    // Tests for the collect method

    @Test
    void collect_ValidInput_ReturnsSortedUniqueCollection() {
        String input = "1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31";
        Collection<Integer> expected = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        Collection<Integer> actual = summarizer.collect(input);
        assertEquals(expected, actual);
    }

    @Test
    void collect_InputWithDuplicates_ReturnsUniqueSortedCollection() {
        String input = "1, 3, 3, 6, 7, 8, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31, 31";
        Collection<Integer> expected = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        Collection<Integer> actual = summarizer.collect(input);
        assertEquals(expected, actual);
    }

    @Test
    void collect_InputWithWhitespace_ReturnsParsedNumbers() {
        String input = " 1 , 3 , 6 ,7,8 , 12 ,13,14 ,15 ,21,22 ,23,24 ,31 ";
        Collection<Integer> expected = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        Collection<Integer> actual = summarizer.collect(input);
        assertEquals(expected, actual);
    }

    @Test
    void collect_EmptyInput_ReturnsEmptyCollection() {
        String input = "   ";
        Collection<Integer> actual = summarizer.collect(input);
        assertTrue(actual.isEmpty());
    }

    @Test
    void collect_NullInput_ReturnsEmptyCollection() {
        String input = null;
        Collection<Integer> actual = summarizer.collect(input);
        assertTrue(actual.isEmpty());
    }

    @Test
    void collect_InvalidNumber_ThrowsIllegalArgumentException() {
        String input = "1, 3, a, 7";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            summarizer.collect(input);
        });
        String expectedMessage = "Invalid number: a";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void collect_InputWithEmptyTokens_IgnoresEmptyTokens() {
        String input = "1, , 3,,6";
        Collection<Integer> expected = Arrays.asList(1, 3, 6);
        Collection<Integer> actual = summarizer.collect(input);
        assertEquals(expected, actual);
    }

    // Tests for the summarizeCollection method

    @Test
    void summarizeCollection_ValidInput_ReturnsCorrectSummary() {
        Collection<Integer> input = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String expected = "1, 3, 6-8, 12-15, 21-24, 31";
        String actual = summarizer.summarizeCollection(input);
        assertEquals(expected, actual);
    }

    @Test
    void summarizeCollection_SingleNumber_ReturnsNumber() {
        Collection<Integer> input = Arrays.asList(5);
        String expected = "5";
        String actual = summarizer.summarizeCollection(input);
        assertEquals(expected, actual);
    }

    @Test
    void summarizeCollection_AllConsecutiveNumbers_ReturnsSingleRange() {
        Collection<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        String expected = "1-5";
        String actual = summarizer.summarizeCollection(input);
        assertEquals(expected, actual);
    }

    @Test
    void summarizeCollection_NoConsecutiveNumbers_ReturnsCommaSeparated() {
        Collection<Integer> input = Arrays.asList(1, 3, 5, 7);
        String expected = "1, 3, 5, 7";
        String actual = summarizer.summarizeCollection(input);
        assertEquals(expected, actual);
    }

    @Test
    void summarizeCollection_EmptyCollection_ReturnsEmptyString() {
        Collection<Integer> input = Collections.emptyList();
        String actual = summarizer.summarizeCollection(input);
        assertEquals("", actual);
    }

    @Test
    void summarizeCollection_NullInput_ReturnsEmptyString() {
        String actual = summarizer.summarizeCollection(null);
        assertEquals("", actual);
    }

    @Test
    void summarizeCollection_UnsortedInput_ReturnsSortedSummary() {
        Collection<Integer> input = Arrays.asList(8, 6, 7, 1, 3, 24, 22, 23, 12, 13, 14, 15, 21, 31);
        String expected = "1, 3, 6-8, 12-15, 21-24, 31";
        String actual = summarizer.summarizeCollection(input);
        assertEquals(expected, actual);
    }

    @Test
    void summarizeCollection_InputWithDuplicates_IgnoresDuplicates() {
        Collection<Integer> input = Arrays.asList(1, 3, 3, 6, 7, 8, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31, 31);
        String expected = "1, 3, 6-8, 12-15, 21-24, 31";
        String actual = summarizer.summarizeCollection(input);
        assertEquals(expected, actual);
    }
}
