package pac;
import java.util.logging.Logger;
import java.lang.IllegalStateException;

import structs.LinkedStackQueue;

public class Main {

    private Main() {
        throw new IllegalStateException("Utility class");
      }

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main() {
        LinkedStackQueue<Integer> stackQueue = new LinkedStackQueue<>();
        stackQueue.push(10);
        stackQueue.push(20);
        stackQueue.enqueue(30);
       logger.info("Popped value: " + stackQueue.pop()); // 30
       logger.info("Dequeued value: " + stackQueue.dequeue()); // 10
    }
}