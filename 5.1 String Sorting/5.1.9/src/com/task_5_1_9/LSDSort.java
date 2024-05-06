package com.task_5_1_9;

public class LSDSort {
    private LSDSort() {}

    public static void sort(String[] a) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        int maxLen = getMaxLen(a);

        for (int d = maxLen - 1; d >= 0; d--) {
            int[] count = new int[R + 1];

            for (int i = 0; i < N; i++) {
                int charAtD = getCharAtD(a[i], d, 0);
                count[charAtD + 1]++;
            }

            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            for (int i = 0; i < N; i++) {
                int charAtD = getCharAtD(a[i], d, 0);
                aux[count[charAtD]++] = a[i];
            }

            System.arraycopy(aux, 0, a, 0, N);
        }
    }

    private static int getMaxLen(String[] a) {
        int maxLen = 0;
        for (String s : a) {
            if (s.length() > maxLen) {
                maxLen = s.length();
            }
        }
        return maxLen;
    }

    private static int getCharAtD(String s, int d, int defaultValue) {
        return d < s.length() ? s.charAt(d) : defaultValue;
    }
}