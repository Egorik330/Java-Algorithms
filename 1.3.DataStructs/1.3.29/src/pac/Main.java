package pac;
import java.util.logging.Logger;

import structs.Queue;

public class Main {
    private static final Logger l = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.enqueue(21);
        q.enqueue(2);
        q.enqueue(4);
        q.enqueue(54);
        l.info("21 2 4 54");
        if (l.isLoggable(java.util.logging.Level.INFO)) {
            l.info("Текущий размер: " + q.size());
            l.info("Удаленный элемент: " + q.dequeue());
            l.info("Текущий размер: " + q.size());
        }
    }
}