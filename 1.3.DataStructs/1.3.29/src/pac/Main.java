package pac;
import java.util.logging.Logger;
import java.lang.IllegalStateException;

import structs.Queue;

public class Main {
    private static final Logger logger= Logger.getLogger(Main.class.getName());

    private Main() {
        throw new IllegalStateException("Utility class");
      }

    public static void main() {
        Queue<Integer> q = new Queue<>();
        q.enqueue(21);
        q.enqueue(2);
        q.enqueue(4);
        q.enqueue(54);
        logger.info("21 2 4 54");
        if (logger.isLoggable(java.util.logging.Level.INFO)) {
            logger.info("Текущий размер: " + q.size());
            logger.info("Удаленный элемент: " + q.dequeue());
            logger.info("Текущий размер: " + q.size());
        }
    }
}