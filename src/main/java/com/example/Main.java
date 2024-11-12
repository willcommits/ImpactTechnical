package com.example;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        
        try {
            Collection<Integer> numbers = summarizer.collect(input);
            String summary = summarizer.summarizeCollection(numbers);
            System.out.println("Input: " + input);
            System.out.println("Summary: " + summary);
        } catch (IllegalArgumentException e) {
            System.err.println("Error processing input: " + e.getMessage());
        }
    }
}
