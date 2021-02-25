package fa.dfa;

import java.util.*;
import fa.State;

public class DFA implements DFAInterface 
{

    private HashSet<Character> alphabet;
    private LinkedHashSet<String> originalTransitions;
    private LinkedHashSet<DFAState> Q;

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
        // TODO Auto-generated method stub
        return null;
    }

    /**
	 * Getter for F
	 * @return a set of final states that FA has
	 */
    public Set<? extends fa.State> getFinalStates() 
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
	 * Getter for q0
	 * @return the start state of FA
	 */
    public fa.State getStartState() 
    {
        // TODO Auto-generated method stub
        return null;
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
        // TODO Auto-generated method stub
        return null;
    }
        
}
