package pac;
import java.util.logging.Logger;
import java.lang.IllegalStateException;
import java.util.Scanner;

import structs.Parenthes;
import structs.Stack;

public class Main {

    private Main() {
        throw new IllegalStateException("Utility class");
    }

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        if (LOGGER.isLoggable(java.util.logging.Level.INFO)) {
            LOGGER.info("Введите строку из скобок для проверки:");
            String test = scanner.nextLine();
            
            if (!test.matches("[()\\[\\]{}]*")) {
                LOGGER.info("Введенная строка должна состоять только из различных видов скобок.");
            } else {
                boolean ans = Parenthes.isCorrect(test, stack);
                LOGGER.info("Answer for " + test + " :" + ans);
            }
        }
        scanner.close();
    }  
}
