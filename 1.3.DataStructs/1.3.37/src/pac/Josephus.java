package pac;
import java.util.logging.Logger;
import java.lang.IllegalStateException;

import structs.Queue; 
 
public class Josephus { 
 
    private static final Logger logger = Logger.getLogger(Josephus.class.getName()); 

    private Josephus() {
        throw new IllegalStateException("Utility class");
      }
    public static void main(String[] args) { 
        if (args.length != 2) { 
            logger.info("Usage: java Josephus <N> <M>"); 
            return; 
        } 
 
        int n= Integer.parseInt(args[0]); 
        int m= Integer.parseInt(args[1]); 
 
        Queue<Integer> queue = new Queue<Integer>(); 
        for (int i = 0; i < n; i++) { 
            queue.enqueue(i); 
        } 
 
        while (queue.size() > 0) { 
            for (int i = 0; i < m - 1; i++) { 
                int removed = queue.dequeue(); 
                queue.enqueue(removed); 
            } 
            logger.info(queue.dequeue()); 
            logger.info(" "); 
        } 
    } 
}