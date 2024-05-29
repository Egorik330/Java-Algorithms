package com.task5_2_17;

public class SpellChecker {
    private static class TSTNode {
        char character;
        TSTNode left, middle, right;
        boolean isEndOfWord;
        
        public TSTNode(char character) {
            this.character = character;
        }
    }

    private TSTNode root;

    public void insert(String word) {
        root = insert(root, word, 0);
    }

    private TSTNode insert(TSTNode node, String word, int index) {
        char character = word.charAt(index);
        if (node == null) {
            node = new TSTNode(character);
        }
        if (character < node.character) {
            node.left = insert(node.left, word, index);
        } else if (character > node.character) {
            node.right = insert(node.right, word, index);
        } else {
            if (index + 1 < word.length()) {
                node.middle = insert(node.middle, word, index + 1);
            } else {
                node.isEndOfWord = true;
            }
        }
        return node;
    }

    public boolean contains(String word) {
        return contains(root, word, 0);
    }

    private boolean contains(TSTNode node, String word, int index) {
        if (node == null) {
            return false;
        }
        char character = word.charAt(index);
        if (character < node.character) {
            return contains(node.left, word, index);
        } else if (character > node.character) {
            return contains(node.right, word, index);
        } else {
            if (index + 1 == word.length()) {
                return node.isEndOfWord;
            }
            return contains(node.middle, word, index + 1);
        }
    }
}