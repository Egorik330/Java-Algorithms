package structs;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private Node last;
    private int capacity;

    private class Node {
        T value;
        Node next;
    }

    public boolean isEmpty() { return capacity==0; }

    public int size() { return capacity; }

    public void enqueue(T value) {
        Node oldLast = last;
        last = new Node();
        last.value = value;

        if (isEmpty()) {
            last.next = last;
        } else {
            last.next = oldLast.next;
            oldLast.next = last;
        }
        
        capacity++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Очередь пуста");
        }

        T dequeuedElement = last.next.value; 
        if (last.next == last) {
            last=null;
        } else {
            last.next=last.next.next;
        }

        capacity--;
        return dequeuedElement;
    }
    
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        private Node current = last.next;
        private int count = 0;

        public boolean hasNext() {
            return count < capacity;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T value = current.value;
            current = current.next;
            count++;
            return value;
        }
    }
}
