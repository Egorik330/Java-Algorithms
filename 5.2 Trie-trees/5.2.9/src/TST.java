import java.util.LinkedList;
import java.util.Queue;

public class TST<Value> {
    private Node<Value> root;

    private static class Node<Value> {
        private char character;
        private Node<Value> left, middle, right;
        private Value value;
    }

    public void put(String key, Value value) {
        root = put(root, key, value, 0);
    }

    private Node<Value> put(Node<Value> node, String key, Value value, int depth) {
        char character = key.charAt(depth);
        if (node == null) {
            node = new Node<>();
            node.character = character;
        }

        if (character < node.character) {
            node.left = put(node.left, key, value, depth);
        } else if (character > node.character) {
            node.right = put(node.right, key, value, depth);
        } else if (depth < key.length() - 1) {
            node.middle = put(node.middle, key, value, depth + 1);
        } else {
            node.value = value;
        }
        return node;
    }

    public Value get(String key) {
        Node<Value> node = get(root, key, 0);
        if (node == null) return null;
        return node.value;
    }

    private Node<Value> get(Node<Value> node, String key, int depth) {
        if (node == null) return null;

        char character = key.charAt(depth);

        if (character < node.character) return get(node.left, key, depth);
        else if (character > node.character) return get(node.right, key, depth);
        else if (depth < key.length() - 1) return get(node.middle, key, depth + 1);
        else return node;
    }

    public Iterable<String> keys() {
        Queue<String> queue = new LinkedList<>();
        collect(root, new StringBuilder(), queue);
        return queue;
    }

    private void collect(Node<Value> node, StringBuilder prefix, Queue<String> queue) {
        if (node == null) return;

        collect(node.left, prefix, queue);

        if (node.value != null) queue.add(prefix.toString() + node.character);

        collect(node.middle, prefix.append(node.character), queue);
        prefix.deleteCharAt(prefix.length() - 1);
        collect(node.right, prefix, queue);
    }

    public String longestPrefixOf(String query) {
        if (query == null || query.length() == 0) return null;

        int length = 0;
        Node<Value> node = root;
        int i = 0;
        while (node != null && i < query.length()) {
            char character = query.charAt(i);
            if (character < node.character) node = node.left;
            else if (character > node.character) node = node.right;
            else {
                i++;
                if (node.value != null) length = i;
                node = node.middle;
            }
        }
        return query.substring(0, length);
    }

    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> queue = new LinkedList<>();
        Node<Value> node = get(root, prefix, 0);
        if (node == null) return queue;
        if (node.value != null) queue.add(prefix);
        collect(node.middle, new StringBuilder(prefix), queue);
        return queue;
    }

    public Iterable<String> keysThatMatch(String pattern) {
        Queue<String> queue = new LinkedList<>();
        collect(root, new StringBuilder(), 0, pattern, queue);
        return queue;
    }

    private void collect(Node<Value> node, StringBuilder prefix, int depth, String pattern, Queue<String> queue) {
        if (node == null) return;
        char character = pattern.charAt(depth);

        if (character == '.' || character < node.character) collect(node.left, prefix, depth, pattern, queue);

        if (character == '.' || character == node.character) {
            if (depth == pattern.length() - 1 && node.value != null) queue.add(prefix.toString() + node.character);
            if (depth < pattern.length() - 1) {
                collect(node.middle, prefix.append(node.character), depth + 1, pattern, queue);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
        
        if (character == '.' || character > node.character) collect(node.right, prefix, depth, pattern, queue);
    }
}