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
        int n;
        boolean color;
        
        Node(K key, V value, int n, boolean color) {
            this.key = key;
            this.value = value;
            this.n = n;
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

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.n;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private boolean isRed(Node x) {
        return x != null && x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public V get(K key){
        if(lastAccessedNode != null && lastAccessedNode.key == key){
            return lastAccessedNode.value;
        }
        else {
            Node node = get(root, key);
            if(node != null) {
                return node.value;
            }
            else {
                return null;
            }
        }
    }

    private Node get(Node node, K key) {
        if(node == null) {
            return null;
        }

        while(key != node.key){
            if(key.compareTo(node.key) > 0) {
                node = node.right;
            }
            else if(key.compareTo(node.key) < 0) {
                node = node.left;
            }
            
            if(node == null) {
                return null;
            }
        }
        lastAccessedNode = node;
        return node;
    }

    public void put(K key, V val) {
        if(lastAccessedNode != null && lastAccessedNode.key == key){
            lastAccessedNode.value = val;
        }
        else{
            root = put(root, key, val);
            root.color = BLACK;
        }
    }

    private Node put(Node h, K key, V val) {
        if (h == null) {
            lastAccessedNode = new Node(key, val, 1, RED); 
            return lastAccessedNode;
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, val);
        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
        } else {
            h.value = val;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        h.n = size(h.left) + size(h.right) + 1;
        return h;
    }
}