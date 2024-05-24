package com.task5_4_9;

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
        this.transitionTable = new int[numStates][2]; // 2 символа: 0 и 1
        this.startState = startState;

        for (int i = 0; i < numStates; i++) {
            for (int j = 0; j < 2; j++) {
                transitionTable[i][j] = -1;
            }
        }
    }

    public void addTransition(int fromState, int input, int toState) {
        transitionTable[fromState][input] = toState;
    }

    public void reset() {
        currentStates.clear();
        currentStates.add(startState);
    }

    public void processInput(char input) {
        Set<Integer> newStates = new HashSet<>();

        for (int state : currentStates) {
            int inputIndex = input - '0';
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