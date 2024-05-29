package com.task_3_4_39;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAnalysis {

    private RandomAnalysis() {
          
    }

    private static List<Integer> fillWithUniqueKeys(int size) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(0); 
        }
        Random random = new Random(); 
        for (int i = 0; i < size / 2; i++) {
            int key = random.nextInt(size);
            int index = key % size;
            while (result.get(index) != 0) {
                index = (index + 1) % size; 
            }
            result.set(index, key);
        }
        return result;
    }

    public static double calculateMisses(int size) {
        List<Integer> arr = fillWithUniqueKeys(size);
        int misses = 0;
        int operations = 0;

        for (int i = 0; i < size; i++) {
            if (arr.get(i) != 0) { 
                int startIndex = i;
                int j = startIndex;
                do {
                    j = (j + 1) % size;
                    misses++;
                } while (arr.get(j) == 0 && j != startIndex); 
                operations++;
                i = j; 
            }
        }
        return operations == 0 ? 0 : (double) misses / operations;
    }
}