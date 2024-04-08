package structs;
import java.util.NoSuchElementException;

public class LinkedStackQueue<T> {
    private Node front; // Начало очереди
    private Node rear; // Конец очереди

    public LinkedStackQueue() {
        this.front = null;
        this.rear = null;
    }

    private class Node {
        T data;
        Node next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

   
    public void push(T value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("стеко-очередь пуста");
        }
        T poppedValue = rear.data;
        rear = null;
        return poppedValue;
    }

   
    public void enqueue(T value) {
        push(value); 
    }

    // Извлечение элемента из очереди
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("стеко-очередь пуста");
        }
        T dequeuedValue = front.data;
        front = front.next;
        return dequeuedValue;
    }

    public boolean isEmpty() {
        return front == null;
    }
}