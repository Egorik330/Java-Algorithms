package com.task_5_1_20;
import java.util.Random;

public class Main {
    public static void main() {
        int N = 10;
        int W = 5; 

        String[] words = randomFixedLengthWords(N, W);
        System.out.println("Generated words:");

        for (String word : words) {
            System.out.println(word);
        }
    }

    public static String[] randomFixedLengthWords(int N, int W) {
    String[] words = new String[N];
    Random random = new Random();
    for (int i = 0; i < N; i++) {
        StringBuilder word = new StringBuilder();
        for (int j = 0; j < W; j++) {
            char c = (char) ('a' + random.nextInt(26));
            word.append(c);
        }
        words[i] = word.toString();
    }
    return words;
    }
}
