package com.task5_4_20;

import java.util.Set;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        
        int numStates = 3;
        int startState = 0;
        Set<Integer> acceptingStates = Set.of(2);

        NFA nfa = new NFA(numStates, startState, acceptingStates);

        nfa.addRangeTransition(0, 'a', 'z', 1); 
        nfa.addRangeTransition(1, '0', '9', 2); 

        String[] testStrings = {
            "m5",      
            "z9",      
            "a0",     
            "aa",     
            "5z",      
            "m59",
            "m&"      
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