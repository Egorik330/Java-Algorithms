package com.task2_5_16;

public class Quick {
    private static String alphabet = "RWQOJMVAHBSGZXNTCIEKUPDYFL";
    public static void sort(String[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(String[] a, int lo, int hi) {
        if (hi<=lo) return;
        int j = partition(a, lo, hi);
        sort(a, 0, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(String [] a, int lo, int hi) {
        int i = lo, j = hi+1;
        String v = a[lo];

        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i>=j) break;
            exch(a,i,j);
        }

        exch(a, lo, j);
        return j;
    }
 

    public static boolean less(String str1, String str2) {
        int size = Math.min(str1.length(), str2.length());

        for (int i =0; i<size; i++){
            if (alphabet.indexOf(str1.charAt(i)) > alphabet.indexOf(str2.charAt(i))) 
                return false;
            else if (alphabet.indexOf(str1.charAt(i)) < alphabet.indexOf(str2.charAt(i))) 
                return true;
        }

        if (str1.length()<=str2.length()) return false;
        return true;
    }

    public static void exch(String[] a, int i, int j) {
        String t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
