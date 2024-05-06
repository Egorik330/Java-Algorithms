package com.task_3_4_1;

import java.util.*;

public class HashTable {
    static final int M = 5;
    List<List<Character>> hashTable = new ArrayList<>(M);

    public HashTable() {
        for (int i = 0; i < M; i++) {
            hashTable.add(new LinkedList<>());
        }
    }

    private int hashFunction(char ch) {
        int K = Character.toUpperCase(ch) - 'A' + 1;
        return 11 * K % M;
    }

    public void insert(char key) {
        int index = hashFunction(key);
        hashTable.get(index).add(key);
    }

    public void printTable() {
        for (int i = 0; i < M; i++) {
            System.out.print(i + ": ");
            for (char key : hashTable.get(i)) {
                System.out.print(key + " ");
            }
            System.out.println();
        }
    }
}