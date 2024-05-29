package com.task_5_1_15;

public class Main {
    public static void main() {
        
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Before sorting:");
        printArray(arr);

        HybridSort.sort(arr);

        System.out.println("After sorting:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}