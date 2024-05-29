package com.task_5_3_21;

public class RabinKarp {
    private long patternHash1;
    private long patternHash2;
    private int patternLength;
    private long prime = 997;
    private int radix = 256;
    private long radixPowerMid; 
    private int mid;

    public RabinKarp(String pattern) {
        this.patternLength = pattern.length();
        mid = patternLength / 2;
        radixPowerMid = 1;
        for (int i = 1; i < patternLength; i++) {
            radixPowerMid = (radix * radixPowerMid) % prime;
        }
        patternHash1 = hash(pattern, 0, mid);
        patternHash2 = hash(pattern, mid + 1, patternLength);
    }

    private long hash(String key, int start, int end) {
        long h = 0;
        for (int j = start; j < end; j++) {
            h = (h * radix + key.charAt(j)) % prime;
        }
        return h;
    }

    public int search(String text) {
        int textLength = text.length();
        long textHash1 = hash(text, 0, mid);
        long textHash2 = hash(text, mid + 1, patternLength);
        if (patternHash1 == textHash1 && patternHash2 == textHash2) {
            return 0;
        }
        for (int i = patternLength; i < textLength; i++) {
            textHash1 = (textHash1 + prime - radixPowerMid * text.charAt(i - patternLength) % prime) % prime;
            textHash1 = (textHash1 * radix + text.charAt(i - mid)) % prime;
            textHash2 = (textHash2 + prime - radixPowerMid * text.charAt(i - mid) % prime) % prime;
            textHash2 = (textHash2 * radix + text.charAt(i)) % prime;
            if (patternHash1 == textHash1 && patternHash2 == textHash2)
                return i - patternLength + 1;
        }
        return textLength;
    }
}
