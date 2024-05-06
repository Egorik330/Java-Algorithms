package com.task_5_1_9;

public class Main {
    public static void main() {
        String[] a = { "abc", "abcd", "ab", "a", "abcde" };

        System.out.println("До сортировки: ");
        for (String s : a) {
            System.out.print(s + " ");
        }
        System.out.println();
        
        LSDSort.sort(a);

        System.out.println("После сортировки: ");
        for (String s : a) {
            System.out.print(s + " ");
        }
    }
}
