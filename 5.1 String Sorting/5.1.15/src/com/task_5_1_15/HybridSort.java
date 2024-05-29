package com.task_5_1_15;

public class HybridSort {
    public static void sort(int[] a) {
        lsdRadixSort(a, 16);
        insertionSort(a);
    }

    private static void lsdRadixSort(int[] a, int bits) {
        int n = a.length;
        int R = 1 << bits;
        int[] count = new int[R + 1];

        for (int i = 0; i < n; i++) {
            int key = (a[i] >> (32 - bits)) & (R - 1);
            count[key + 1]++;
        }

        for (int i = 0; i < R; i++) {
            count[i + 1] += count[i];
        }

        int[] aux = new int[n];
        for (int i = 0; i < n; i++) {
            int key = (a[i] >> (32 - bits)) & (R - 1);
            aux[count[key]++] = a[i];
        }

        System.arraycopy(aux, 0, a, 0, n);
    }

    private static void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
}