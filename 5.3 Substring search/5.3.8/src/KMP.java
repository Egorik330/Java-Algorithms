package com.task5_3_8;

import java.util.ArrayList;
import java.util.List;

public class KMP {
    private String pattern;
    private int[][] dfa;

    public KMP(String pattern) {
        this.pattern = pattern;
        int patternLength = pattern.length();
        int alphabetSize = 256;
        dfa = new int[alphabetSize][patternLength];
        dfa[pattern.charAt(0)][0] = 1;
        
        for (int restartState = 0, j = 1; j < patternLength; j++) {
            for (int charIndex = 0; charIndex < alphabetSize; charIndex++) {
                dfa[charIndex][j] = dfa[charIndex][restartState]; 
            }
            dfa[pattern.charAt(j)][j] = j + 1; 
            restartState = dfa[pattern.charAt(j)][restartState]; 
        }
    }

    public int search(String text, int start) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int i, j;
        
        for (i = start, j = 0; i < textLength && j < patternLength; i++) {
            j = dfa[text.charAt(i)][j];
        }
        
        if (j == patternLength) {
            return i - patternLength; 
        } else {
            return textLength;
        }
    }

    public int count(String text) {
        int matchCount = 0;
        int position = search(text, 0);
        
        while (position < text.length()) {
            matchCount++;
            position = search(text, position + pattern.length());
        }
        
        return matchCount;
    }

    public List<Integer> searchAll(String text) {
        List<Integer> matchPositions = new ArrayList<>();
        int position = search(text, 0);
        
        while (position < text.length()) {
            matchPositions.add(position);
            position = search(text, position + pattern.length());
        }
        
        return matchPositions;
    }
}