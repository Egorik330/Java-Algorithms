package com.task5_2_14;

public class UniqueSubstrings {
    private static class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private boolean isEndOfWord;
    }

    private TrieNode root;

    public UniqueSubstrings() {
        root = new TrieNode();
    }

    public void insert(String key) {
        TrieNode node = root;
        for (char ch : key.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String key) {
        TrieNode node = root;
        for (char ch : key.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node != null && node.isEndOfWord;
    }
}