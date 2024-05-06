package com.task_3_4_39;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000};

        for (int size : sizes) {
           
            long startTime = System.currentTimeMillis();

            double averageMisses = RandomAnalysis.calculateMisses(size);

            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            System.out.println("Test for size " + size + ":");
            System.out.println("Average Misses: " + averageMisses);
            System.out.println("Duration: " + duration + " ms");
            System.out.println();
        }
    }
}