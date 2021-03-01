/**
 * The following code contains the methods used to create and navigate
 * a Difinite Finite Automata.
 * @authors: Jeremy Bouchard and Sam Jackson
 */
package fa.dfa;

import java.util.*;
import fa.State;

public class DFA implements DFAInterface
{

    private HashSet<Character> alphabet;
    private LinkedHashSet<String> originalTransitions;
    private LinkedHashSet<DFAState> Q;

    /**
     * Constructor that creates the base DFA.
     */
    public DFA()
    {
        alphabet = new HashSet<Character>();
        originalTransitions = new LinkedHashSet<String>();
        Q = new LinkedHashSet<DFAState>();
    }

    /**
	 * Simulates a DFA on input s to determine
	 * whether the DFA accepts s.
	 * @param s - the input string
	 * @return true if s in the language of the DFA and false otherwise
	 */
    public boolean accepts(String s)
    {
        State startState = getStartState();
        DFAState currentState = new DFAState("");

        Iterator<DFAState> it = Q.iterator();
        while(it.hasNext())
        {
            currentState = it.next();
            if(currentState.getName().equals(startState.getName()))
            {
                break;
            }
        }

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(Character.valueOf(c).equals('e') && currentState.getEndState())
            {
                return true;
            }
            currentState = (DFAState)getToState(currentState, c);
            if(currentState == null)
            {
                return false;
            }
        }

        if(currentState.getEndState())
        {
            return true;
        }

        return false;
    }

    /**
	 * Adds the initial state to the DFA instance
	 * @param name is the label of the start state
	 */
    public void addStartState(String name)
    {
        DFAState state = new DFAState(name);
        state.setStartState(true);

        /**
         * If no start state, adds start state. If there is start state,
         * but it's not labeled correctly, then set state to start state.
         */
        if(!(Q.add(state)))
        {
            Iterator<DFAState> it = Q.iterator();
            while(it.hasNext())
            {
                state = it.next();
                if(state.getName().equals(name))
                {
                    state.setStartState(true);
                }
            }
        }
    }

    /**
	 * Adds a non-final, not initial state to the DFA instance
	 * @param name is the label of the state
	 */
    public void addState(String name)
    {
        DFAState state = new DFAState(name);
        Q.add(state);
    }

    /**
	 * Adds a final state to the DFA
	 * @param name is the label of the state
	 */
    public void addFinalState(String name)
    {
        DFAState state = new DFAState(name);
        state.setEndState(true);
        Q.add(state);
    }

    /**
	 * Adds the transition to the DFA's delta data structure
	 * @param fromState is the label of the state where the transition starts
	 * @param onSymb is the symbol from the DFA's alphabet.
	 * @param toState is the label of the state where the transition ends
	 */
    public void addTransition(String fromState, char onSymb, String toState)
    {
        alphabet.add(onSymb);
        originalTransitions.add(fromState + onSymb + toState);

        Iterator<DFAState> it = Q.iterator();
        while(it.hasNext())
        {
            DFAState previousState = it.next();
            if(previousState.getName().equals(fromState))
            {
                previousState.addStateTransition(toState, onSymb);
                break;
            }
        }
    }

    /**
	 * Getter for Q
	 * @return a set of states that FA has
	 */
    public Set<? extends fa.State> getStates()
    {
        LinkedHashSet<DFAState> returnStates = new LinkedHashSet<DFAState>();

        Iterator<DFAState> iter = Q.iterator();
        while(iter.hasNext()){
            DFAState state = iter.next();
            returnStates.add(state);
        }
        return returnStates;
    }

    /**
	 * Getter for Final States
	 * @return a set of final states that FA has
	 */
    public Set<? extends fa.State> getFinalStates()
    {
        LinkedHashSet<DFAState> returnStates = new LinkedHashSet<DFAState>();

        Iterator<DFAState> iter = Q.iterator();
        while(iter.hasNext()){
            DFAState maybeFinal = iter.next();
            if(maybeFinal.getEndState()){ //If the state we're checking is an end state, add to list
                returnStates.add(maybeFinal);
            }
        }
        return returnStates;
    }

    /**
	 * Getter for q0
	 * @return the start state of FA
	 */
    public fa.State getStartState()
    {
        DFAState maybeStart = null;

        Iterator<DFAState> iter = Q.iterator();
        while(iter.hasNext()){
            maybeStart = iter.next();
            if(maybeStart.getStartState()){
                return maybeStart; //There should only be one
            }
        }
        return maybeStart;
    }

    /**
	 * Getter for Sigma
	 * @return the alphabet of FA
	 */
    public Set<Character> getABC()
    {
        return alphabet;
    }

    /**
	 * Uses transition function delta of FA
	 * @param from the source state
	 * @param onSymb the label of the transition
	 * @return the sink state.
	 */
    public fa.State getToState(DFAState from, char onSymb)
    {
        LinkedList<Map.Entry<Character,String>> trans = from.getStateTransitions();

        for(Map.Entry<Character,String> i: trans){
            if(i.getKey().equals((Character)onSymb)){
                Iterator<DFAState> iter = Q.iterator();
                while(iter.hasNext()){
                    DFAState curr = iter.next();
                    if(curr.getName().equals(i.getValue()))
                        return curr; //If found return it
                }
            }
        }
        return null; //if not found, dne
    }

    /**
     * This method takes the information found from a DFA
     * and prints it as readable information.
     * @return Readable information in the form of a String
    */
    public String toString()
    {
        //Print everything in the five tuple
        //This section handle's Q
        StringBuilder capitalQ = new StringBuilder();
        capitalQ.append("Q = { ");
        Iterator<DFAState> iter = Q.iterator();
        ArrayList<DFAState> stateList = new ArrayList<DFAState>();
        while(iter.hasNext()){
            DFAState curr = iter.next();
            capitalQ.append(" " + curr.toString() + " ");
            stateList.add(curr);
        }
        capitalQ.append(" }\n");

        //This section handles Sigma
        StringBuilder sigma = new StringBuilder();
        sigma.append("Sigma = {");
        Iterator<Character> iterChar = alphabet.iterator();
        ArrayList<Character> charList = new ArrayList<Character>();
        while(iterChar.hasNext()){
            Character character = iterChar.next();
            sigma.append(" " + character.toString() + " ");
            charList.add(character);
        }
        sigma.append("}\n");


        //This section handles q0 - start state
        StringBuilder startState = new StringBuilder();
        startState.append("q0 = " + getStartState().toString() + "\n");

        //This section handles F - final state
        StringBuilder finalState = new StringBuilder();
        finalState.append("F = {");
        Set<? extends fa.State> finals = getFinalStates(); 
        for(State f : finals) {
            finalState.append(" " + f.toString() + " ");
        }
        finalState.append("}\n");

        //This section handles Delta
        StringBuilder deltaString = new StringBuilder();
        deltaString.append("delta = \n");
        String[][] delta = new String[getStates().size() + 1][getABC().size() + 1];
        delta[0][0] = "         ";

        for(int i = 1; i < getStates().size() + 1; i++){
            delta[i][0] = "     " + stateList.get(i - 1).toString() + "   ";
        }

        for(int i = 1; i < getABC().size() + 1; i++){
            delta[0][i] = charList.get(i - 1).toString() + "  ";
        }

        for(int i = 0; i < getStates().size() + 1; i++){
            for(int j = 0; j < getABC().size() + 1; j++){
                if(delta[i][j] == null){
                    LinkedList<Map.Entry<Character, String>> stateTrans = stateList.get(i - 1).getStateTransitions();
                    delta[i][j] = stateTrans.get(j - 1).toString().substring(2) + "  ";
                }
                deltaString.append(delta[i][j].toString() + "    ");
            }
            deltaString.append("\n");
        }
   
        //This section combines the grabbed information into a single readable string.
        startState.append(finalState.toString());
        deltaString.append(startState.toString());
        sigma.append(deltaString.toString());
        capitalQ.append(sigma.toString());
        return capitalQ.toString();
    }
}
