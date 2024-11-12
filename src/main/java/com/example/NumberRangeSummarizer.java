package com.example;
import java.util.Collection;


public interface NumberRangeSummarizer {

    /**
     * Collects and parses the input string into a collection of integers.
     *
     * @param input the input string containing comma-separated numbers
     * @return a collection of integers parsed from the input
     * @throws IllegalArgumentException if the input contains non-integer values
     */
    Collection<Integer> collect(String input);

    /**
     * Summarizes the collection of integers into a range-based string.
     *
     * @param input the collection of integers to summarize
     * @return a string summarizing the ranges of consecutive numbers
     */
    String summarizeCollection(Collection<Integer> input);
}
