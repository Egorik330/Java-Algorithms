package com.task_3_3_30;

public class RBST<K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    Node lastAccessedNode = null;

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        int size;
        boolean color;

        Node(K key, V value, int size, boolean color) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.color = color;
        }
    }

    private Node root;

    public RBST() {
        root = null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    private Node rotateLeft(Node node) {
        Node rightNode = node.right;
        node.right = rightNode.left;
        rightNode.left = node;
        rightNode.color = node.color;
        node.color = RED;
        rightNode.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);
        return rightNode;
    }

    private Node rotateRight(Node node) {
        Node leftNode = node.left;
        node.left = leftNode.right;
        leftNode.right = node;
        leftNode.color = node.color;
        node.color = RED;
        leftNode.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);
        return leftNode;
    }

    void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public V get(K key) {
        if (lastAccessedNode != null && lastAccessedNode.key.equals(key)) {
            return lastAccessedNode.value;
        } else {
            Node node = get(root, key);
            if (node != null) {
                return node.value;
            } else {
                return null;
            }
        }
    }

    private Node get(Node node, K key) {
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                lastAccessedNode = node;
                return node;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        if (lastAccessedNode != null && lastAccessedNode.key.equals(key)) {
            lastAccessedNode.value = value;
        } else {
            root = put(root, key, value);
            root.color = BLACK;
        }
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            lastAccessedNode = new Node(key, value, 1, RED);
            return lastAccessedNode;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }
}