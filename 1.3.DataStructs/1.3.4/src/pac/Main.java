package pac;
import java.util.logging.Logger;
import java.lang.IllegalStateException;

import structs.Parenthes;
import structs.Stack;

public class Main
{

    private Main() {
        throw new IllegalStateException("Utility class");
      }

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main() {
        Stack<Character> stack = new Stack<>();
        if (logger.isLoggable(java.util.logging.Level.INFO)) {
            String test1 = "{([])}";
            boolean ans1 = Parenthes.isCorrect(test1, stack);
            logger.info("Answer for " + test1+" :"+ans1);
            String test2 = "[(])"; 
            boolean ans2 = Parenthes.isCorrect(test2, stack);
            logger.info("Answer for " + test2+" :" + ans2);
        }
 }
}
