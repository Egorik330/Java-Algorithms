package structs;
import java.util.*;

public class Stack<T> {
    private Node first;
    private int n;
    private class Node {
        
        T value;
        Node next;
    }
    public boolean isEmpty() {
        return first == null; 
    }
    public int size() {
        return n;
    }
    public void push(T T) {
        
        Node oldfirst = first;
        first = new Node();
        first.value = T;
        first.next = oldfirst;
        n++;
    }
    public T pop() {
       
        if (isEmpty()) {
            throw new NoSuchElementException("Стек пуст");
        }
        T val = first.value;
        first = first.next;
        n--;
        return val;
    }
}