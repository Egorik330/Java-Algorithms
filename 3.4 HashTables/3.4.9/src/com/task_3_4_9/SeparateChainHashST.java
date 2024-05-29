package com.task_3_4_9;

public class SeparateChainHashST<Key, Value> {
    private int numberOfPairs;
    private int tableSize;
    private Node[] table;

    private static class Node<Key, Value> {
        Key key;
        Value value;
        Node<Key, Value> next;

        public Node(Key key, Value value, Node<Key, Value> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public SeparateChainHashST(int tableSize) {
        this.tableSize = tableSize;
        table = new Node[tableSize];
        numberOfPairs = 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % tableSize;
    }

    public void put(Key key, Value value) {
        int index = hash(key);
        for (Node<Key, Value> node = table[index]; node != null; node = node.next) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        table[index] = new Node<Key, Value>(key, value, table[index]);
        numberOfPairs++;
    }

    public Value get(Key key) {
        int index = hash(key);
        for (Node<Key, Value> node = table[index]; node != null; node = node.next) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public void delete(Key key) {
        int index = hash(key);
        Node<Key, Value> node = table[index];
        Node<Key, Value> previousNode = null;

        while (node != null) {
            if (node.key.equals(key)) {
                if (previousNode == null) {
                    table[index] = node.next;
                } else {
                    previousNode.next = node.next;
                }
                numberOfPairs--;
                return;
            }
            previousNode = node;
            node = node.next;
        }
    }

    public int size() {
        return numberOfPairs;
    }

    public boolean isEmpty() {
        return numberOfPairs == 0;
    }
}
