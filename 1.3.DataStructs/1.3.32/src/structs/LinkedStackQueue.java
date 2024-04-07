package structs;
import java.util.NoSuchElementException;

public class LinkedStackQueue<Item> {
    private Node front; // Начало очереди
    private Node rear; // Конец очереди

    Item N;

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
    }

    
    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("стеко-очередь пуста");
        }
        Item poppedValue = rear.data;
        rear = null;
        return poppedValue;
    }

   
    public void enqueue(Item value) {
        push(value); 
    }

    // Извлечение элемента из очереди
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("стеко-очередь пуста");
        }
        Item dequeuedValue = front.data;
        front = front.next;
        return dequeuedValue;
    }

    public boolean isEmpty() {
        return front == null;
    }
}