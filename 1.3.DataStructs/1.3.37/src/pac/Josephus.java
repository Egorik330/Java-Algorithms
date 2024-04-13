package pac;
import java.util.logging.Logger;

import structs.Queue; 
 
public class Josephus { 
    private static final Logger LOGGER = Logger.getLogger(Josephus.class.getName()); 

    public static void main(String[] args) { 
        if (args.length != 2) { 
            LOGGER.info("Usage: java Josephus <N> <M>"); 
            return; 
        } 
 
        int N = Integer.parseInt(args[0]); 
        int M = Integer.parseInt(args[1]); 
 
        Queue<Integer> queue = new Queue<Integer>(); 

        for (int i = 0; i < N; i++) { 
            queue.enqueue(i); 
        } 
 
        while (queue.size() > 0) { 
            for (int i = 0; i < M - 1; i++) { 
                int removed = queue.dequeue(); 
                queue.enqueue(removed); 
            } 
            LOGGER.info(queue.dequeue()+" "); 
        } 
    } 
}
