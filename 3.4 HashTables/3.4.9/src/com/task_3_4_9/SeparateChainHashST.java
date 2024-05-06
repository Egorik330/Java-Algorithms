package com.task_3_4_9;

public class SeparateChainHashST<Key, Value> {
    private int N;       
    private int M;           
    private Node[] table;   

    private static class Node<Key, Value> {
        Key key;
        Value val;
        Node<Key, Value> next;

        public Node(Key key, Value val, Node<Key, Value> next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public SeparateChainHashST(int M) {
        this.M = M;
        table = new Node[M];
        N = 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value val) {
        int i = hash(key);
        for (Node<Key, Value> node = table[i]; node != null; node = node.next) {
            if (node.key.equals(key)) {
                node.val = val;
                return;
            }
        }
        table[i] = new Node<Key, Value>(key, val, table[i]);
        N++;
    }

    public Value get(Key key) {
        int i = hash(key);
        for (Node<Key, Value> node = table[i]; node != null; node = node.next) {
            if (node.key.equals(key)) {
                return node.val;
            }
        }
        return null;
    }

    public void delete(Key key) {
        int i = hash(key);
        Node<Key, Value> node = table[i];
        Node<Key, Value> prev = null;

        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    table[i] = node.next;
                } else {
                    prev.next = node.next;
                }
                N--;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }
}