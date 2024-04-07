package pac;
import java.util.logging.Logger;

import structs.Parenthes;
import structs.Stack;

public class Main
{
    private static final Logger l = Logger.getLogger(Main.class.getName());
   
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        if (l.isLoggable(java.util.logging.Level.INFO)) {
            String test_1 = "{([])}";
            boolean ans1 = Parenthes.isCorrect(test_1, stack);
            l.info("Answer for " + test_1+" :"+ans1);
            String test_2 = "[(])"; 
            boolean ans2 = Parenthes.isCorrect(test_2, stack);
            l.info("Answer for " + test_2+" :" + ans2);
        }

 }
}
