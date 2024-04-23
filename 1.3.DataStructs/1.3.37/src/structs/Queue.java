package structs;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private Node last;
    private int capacity;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public int size() {
        return capacity;
    }

    public void enqueue(Item value) {
        Node oldLast = last;
        last = new Node();
        last.item = value;

        if (isEmpty()) {
            last.next = last;
        } else {
            last.next = oldLast.next;
            oldLast.next = last;
        }

        capacity++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Очередь пуста");
        }

        Item dequeuedValue = last.item;

        if (last.next == last) {
            last = null;
        } else {
            dequeuedValue = last.next.item;
            last.next = last.next.next;
        }

        capacity--;
        return dequeuedValue;
    }

    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private Node current = last.next;
        private int count = 0;

        public boolean hasNext() {
            return count < capacity;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item value = current.item;
            current = current.next;
            count++;
            return value;
        }
    }
}