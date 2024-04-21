package com.task2_5_28;

public class Quick {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi<=lo) return;
        int j = partition(a, lo, hi);
        sort(a, 0, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        Comparable v = a[lo];

        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i>=j) break;
            exch(a,i,j);
        }

        exch(a, lo, j);
        return j;
    }
 

    public static boolean less(Comparable value1, Comparable value2) {
        return value1.compareTo(value2) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
