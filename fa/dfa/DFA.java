package fa.dfa;

import java.util.Set;

public class DFA implements DFAInterface 
{

    /**
	 * Simulates a DFA on input s to determine
	 * whether the DFA accepts s.
	 * @param s - the input string
	 * @return true if s in the language of the DFA and false otherwise
	 */
    public boolean accepts(String s) 
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
	 * Adds the initial state to the DFA instance
	 * @param name is the label of the start state
	 */
    public void addStartState(String name) 
    {
        // TODO Auto-generated method stub

    }

    /**
	 * Adds a non-final, not initial state to the DFA instance
	 * @param name is the label of the state 
	 */
    public void addState(String name) 
    {
        // TODO Auto-generated method stub

    }

    /**
	 * Adds a final state to the DFA
	 * @param name is the label of the state
	 */
    public void addFinalState(String name) 
    {
        // TODO Auto-generated method stub

    }

    /**
	 * Adds the transition to the DFA's delta data structure
	 * @param fromState is the label of the state where the transition starts
	 * @param onSymb is the symbol from the DFA's alphabet.
	 * @param toState is the label of the state where the transition ends
	 */
    public void addTransition(String fromState, char onSymb, String toState) 
    {
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub
        return null;
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
