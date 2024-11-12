package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * Implementation of the NumberRangeSummarizer interface.
 */
public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        if (input == null || input.trim().isEmpty()) {
            return Collections.emptyList();
        }

        String[] tokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            String trimmed = token.trim();
            if (trimmed.isEmpty()) {
                continue; 
            }
            try {
                numbers.add(Integer.parseInt(trimmed));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid number: " + trimmed, e);
            }
        }

        
        List<Integer> sortedNumbers = new ArrayList<>(new TreeSet<>(numbers));
        return sortedNumbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        List<Integer> sortedNumbers = new ArrayList<>(new TreeSet<>(input));

        StringBuilder summary = new StringBuilder();
        int start = sortedNumbers.get(0);
        int end = start;

        for (int i = 1; i < sortedNumbers.size(); i++) {
            int current = sortedNumbers.get(i);
            if (current == end + 1) {
                end = current;
            } else {
                appendRange(summary, start, end);
                start = current;
                end = current;
            }
        }
        appendRange(summary, start, end);

        return summary.toString();
    }

    private void appendRange(StringBuilder summary, int start, int end) {
        if (summary.length() > 0) {
            summary.append(", ");
        }
        if (start == end) {
            summary.append(start);
        } else {
            summary.append(start).append("-").append(end);
        }
    }
}
