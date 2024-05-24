package com.task5_4_18;

import java.util.Set;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

        int numStates = 3;
        int startState = 0;
        Set<Integer> acceptingStates = Set.of(2);

        NFA nfa = new NFA(numStates, startState, acceptingStates);

        nfa.addPlusClosure(0, 'a', 1); 
        nfa.addTransition(1, 'b', 2);  

        String[] testStrings = {
            "ab",      
            "aab",    
            "aaab",    
            "b",     
            "a",       
            "aaa",     
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