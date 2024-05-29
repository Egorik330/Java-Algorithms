package com.task5_2_21;

import java.util.ArrayList;
import java.util.List;

public class SubstringMatcher {
    private static class TSTNode {
        char character;
        TSTNode left, middle, right;
        List<String> words;

        public TSTNode(char character) {
            this.character = character;
            this.words = new ArrayList<>();
        }
    }

    private TSTNode root;

    public void insert(String word) {
        for (int i = 0; i < word.length(); i++) {
            root = insert(root, word.substring(i), word, 0);
        }
    }

    private TSTNode insert(TSTNode node, String suffix, String word, int index) {
        char character = suffix.charAt(index);
        if (node == null) {
            node = new TSTNode(character);
        }
        if (character < node.character) {
            node.left = insert(node.left, suffix, word, index);
        } else if (character > node.character) {
            node.right = insert(node.right, suffix, word, index);
        } else {
            if (!node.words.contains(word)) {
                node.words.add(word);
            }
            if (index + 1 < suffix.length()) {
                node.middle = insert(node.middle, suffix, word, index + 1);
            }
        }
        return node;
    }

    public List<String> search(String query) {
        List<String> result = new ArrayList<>();
        search(root, query, 0, result);
        return result;
    }

    private void search(TSTNode node, String query, int index, List<String> result) {
        if (node == null) {
            return;
        }
        char character = query.charAt(index);
        if (character < node.character) {
            search(node.left, query, index, result);
        } else if (character > node.character) {
            search(node.right, query, index, result);
        } else {
            if (index + 1 == query.length()) {
                result.addAll(node.words);
            } else {
                search(node.middle, query, index + 1, result);
            }
        }
    }
}