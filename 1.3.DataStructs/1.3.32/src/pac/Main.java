package pac;
import java.util.logging.Logger;

import structs.LinkedStackQueue;

public class Main {

    private static final Logger l = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        LinkedStackQueue<Integer> stackQueue = new LinkedStackQueue<>();
        stackQueue.push(10);
        stackQueue.push(20);
        stackQueue.enqueue(30);
       l.info("Popped value: " + stackQueue.pop()); // 30
       l.info("Dequeued value: " + stackQueue.dequeue()); // 10
    }
}