package structs;
import java.util.NoSuchElementException;

public class Queue<Item> {
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
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
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Очередь пуста");
        }
        Item it = last.item;
        if (last.next == last) {
            last = null;
        } else {
            it = last.next.item;
            last.next = last.next.next;
        }
        N--;
        return it;
    }
}