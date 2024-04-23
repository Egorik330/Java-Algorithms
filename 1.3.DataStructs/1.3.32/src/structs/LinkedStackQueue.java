package structs;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class LinkedStackQueue<Item> implements Iterable<Item> {
    private Node front; 
    private Node rear; 
    Integer capacity;

    public LinkedStackQueue() {
        this.front = null;
        this.rear = null;
    }

    private class Node {
        Item data;
        Node next;
        public Node(Item data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(Item value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        capacity++;
    }
    
    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("стеко-очередь пуста");
        }

        Item poppedValue = rear.data;
        rear = null;
        capacity--;
        return poppedValue;
    }

    public void enqueue(Item value) {
        push(value); 
        capacity++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("стеко-очередь пуста");
        }
        
        Item dequeuedValue = front.data;
        front = front.next;
        capacity--;
        return dequeuedValue;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public Integer size() {
        return capacity;
    }

    public Iterator<Item> iterator() {
        return new LinkedStackQueueIterator();
    }

    private class LinkedStackQueueIterator implements Iterator<Item> {
        private Node current = front;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item value = current.data;
            current = current.next;
            return value;
        }
    }
}
