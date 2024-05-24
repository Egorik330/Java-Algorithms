package com.task5_4_9;

import java.util.logging.Logger;
import java.util.Set;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        int numStates = 4;
        int startState = 0;
        Set<Integer> acceptingStates = Set.of(3);

        NFA nfa = new NFA(numStates, startState, acceptingStates);

        nfa.addTransition(0, 1, 0); 
        nfa.addTransition(0, 0, 1); 
        nfa.addTransition(1, 1, 2); 
        nfa.addTransition(2, 1, 2); 
        nfa.addTransition(2, 0, 3); 
        nfa.addTransition(3, 1, 3); 

        String[] testStrings = {
            "1001",  
            "110110", 
            "000",    
            "1010",   
            "1111",   
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
