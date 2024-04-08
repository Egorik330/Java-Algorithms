package structs;
import java.util.NoSuchElementException;

public class Queue<T>
{
    private Node last;
    private int n;

    private class Node 
    {
        T value;
        Node next;
    }
    public boolean isEmpty(){return n==0;}
    public int size(){return n;}
    public void enqueue(T value)
    {
        Node oldLast = last;
        last = new Node();
        last.value = value;
        if (isEmpty()) last.next = last;
        else 
        {
            last.next = oldLast.next;
            oldLast.next = last;
        }
        n++;
    }

    public T dequeue()
    {
         if (isEmpty())
            throw new NoSuchElementException("Очередь пуста");
        T it = last.value;
        if (last.next == last)  last=null;
        else 
        {
            it = last.next.value; 
            last.next=last.next.next;
        }
        n--;
        return it;
    }
}