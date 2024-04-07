package structs;
import java.util.*;

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;
    private class Node {
        
        Item item;
        Node next;
    }
    public boolean isEmpty() {
        return first == null; 
    }
    public int size() {
        return N;
    }
    public void push(Item item) {
        
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop() {
       
        if (isEmpty()) {
            throw new NoSuchElementException("Стек пуст");
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    public Iterator<Item> iterator() {
        return new StackListIterator();
    }
    private class StackListIterator implements Iterator<Item> {
        private Node curr = first;
        public boolean hasNext() {
            return curr != null;
        }
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = curr.item;
            curr = curr.next;
            return item;
        }
    }
}