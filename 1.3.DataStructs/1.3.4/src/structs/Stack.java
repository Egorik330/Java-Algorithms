package structs;
import java.util.*;

public class Stack<T> implements Iterable<T> {
    private Node first;
    private int capacity;

    private class Node {
        T value;
        Node next;
    }

    public boolean isEmpty() {
        return first == null; 
    }

    public int size() {
        return capacity;
    }

    public void push(T T) {
        Node oldfirst = first;
        first = new Node();
        first.value = T;
        first.next = oldfirst;
        capacity++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Стек пуст");
        }

        T value = first.value;
        first = first.next;
        capacity--;
        return value;
    }

    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}
