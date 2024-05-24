package com.task5_4_18;

import java.util.HashSet;
import java.util.Set;

class NFA {
    private Set<Integer> currentStates;
    private Set<Integer> acceptingStates;
    private int[][] transitionTable;
    private int startState;

    public NFA(int numStates, int startState, Set<Integer> acceptingStates) {
        this.currentStates = new HashSet<>();
        this.acceptingStates = new HashSet<>(acceptingStates);
        this.transitionTable = new int[numStates][256]; 
        this.startState = startState;

        for (int i = 0; i < numStates; i++) {
            for (int j = 0; j < 256; j++) {
                transitionTable[i][j] = -1;
            }
        }
    }

    public void addTransition(int fromState, char input, int toState) {
        transitionTable[fromState][input] = toState;
    }

    public void addPlusClosure(int fromState, char input, int toState) {
        addTransition(fromState, input, toState);
        addTransition(toState, input, toState); //замыкание
    }

    public void reset() {
        currentStates.clear();
        currentStates.add(startState);
    }

    public void processInput(char input) {
        Set<Integer> newStates = new HashSet<>();

        for (int state : currentStates) {
            int inputIndex = input;
            int nextState = transitionTable[state][inputIndex];
            if (nextState != -1) {
                newStates.add(nextState);
            }
        }

        currentStates = newStates;
    }

    public boolean accepts() {
        for (int state : currentStates) {
            if (acceptingStates.contains(state)) {
                return true;
            }
        }
        return false;
    }
}