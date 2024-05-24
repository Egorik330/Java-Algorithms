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
        this.transitionTable = new int[numStates][2]; 
        this.startState = startState;

        for (int i = 0; i < numStates; i++) {
            for (int j = 0; j < 2; j++) {
                transitionTable[i][j] = -1;
            }
        }
    }

    public void addTransition(int fromState, char input, int toState) {
        int inputIndex = input == '0' ? 0 : 1;
        transitionTable[fromState][inputIndex] = toState;
    }

    public void reset() {
        currentStates.clear();
        currentStates.add(startState);
    }

    public void processInput(char input) {
        Set<Integer> newStates = new HashSet<>();
        int inputIndex = input == '0' ? 0 : 1;

        for (int state : currentStates) {
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