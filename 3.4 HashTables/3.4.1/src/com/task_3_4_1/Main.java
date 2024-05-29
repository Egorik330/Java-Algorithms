package com.task_3_4_1;

public class Main {
    public static void main(String[] args) {
        HashTable table = new HashTable();
        char[] keys = {'E', 'A', 'S', 'Y', 'Q', 'U', 'O', 'T', 'I', 'O', 'N'};

        for (char key : keys) {
            table.insert(key);
        }

        table.printTable();
    }
}
