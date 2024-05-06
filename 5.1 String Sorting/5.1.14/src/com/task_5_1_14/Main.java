package com.task_5_1_14;

import java.util.Arrays;

public class Main {
    public static void main() {
        int[][] arrays={
            {1,2,3},
            {3,2,1},
            {2,1,3},
            {2,3,1},
            {1,3,2},
            {3,1,2}
        };
        
        ThreeWaySort.threeWayQuicksort(arrays);
        System.out.println("Отсортированный двумерный массив: ");
        System.out.println(Arrays.deepToString(arrays));
}
}
