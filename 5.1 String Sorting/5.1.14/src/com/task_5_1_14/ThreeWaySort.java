package com.task_5_1_14;

public class ThreeWaySort {
    public static void threeWayQuicksort(int[][] a) {
        threeWayQuicksort(a, 0, a.length - 1);
    }
    
    private static void threeWayQuicksort(int[][] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo;
        int gt = hi;
        int i = lo;
        int[] v = a[lo];
    
        while (i <= gt) {
            int cmp = compare(a[i], v);
            if (cmp < 0) swap(a, lt++, i++);
            else if (cmp > 0) swap(a, i, gt--);
            else i++;
        }
    
        threeWayQuicksort(a, lo, lt - 1);
        threeWayQuicksort(a, gt + 1, hi);
    }
    
    private static int compare(int[] a, int[] b) {
        int minLength = Math.min(a.length, b.length);
        for (int i = 0; i < minLength; i++) {
            if (a[i] < b[i]) return -1;
            if (a[i] > b[i]) return 1;
        }
        if (a.length < b.length) return -1;
        if (a.length > b.length) return 1;
        return 0;
    }
    
    private static void swap(int[][] a, int i, int j) {
        int[] temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}