import java.util.Set;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        int numStates = 2;
        int startState = 0;
        Set<Integer> acceptingStates = Set.of(1);

        NFA nfa = new NFA(numStates, startState, acceptingStates);

        // Определим переходы
        nfa.addTransition(0, '0', 1); 
        nfa.addTransition(0, '1', 0);
        nfa.addTransition(1, '0', 1); 
        nfa.addTransition(1, '1', 0); 

        String[] testStrings = {
            "0",      
            "10",    
            "110",     
            "1010",     
            "100100",   
            "1",       
            "11",      
            "101",    
            "111",     
        };

        for (String testString : testStrings) {
            nfa.reset();
            for (char c : testString.toCharArray()) {
                nfa.processInput(c);
            }
            boolean accepted = nfa.accepts();
           LOGGER.info("Строка: " + testString + " соответствует: " + accepted);
        }
    }
}