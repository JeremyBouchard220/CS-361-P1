/**
 * The following code contains the methods used to create, manipulate,
 * and navigate a specific State within a DFA.
 * @authors: Jeremy Bouchard and Sam Jackson (Both in Section 1)
 */
package fa.dfa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import fa.State;

public class DFAState extends State 
{
    private boolean isEndState, isStartState;
    private HashMap<Character, String> transitionStates;

    
    /**
     * This method is where we create a DFA State.
     * @param name - The name of the State being created.
     */
    public DFAState(String name) 
    {
        this.name = name;
        transitionStates = new HashMap<Character, String>();
        isEndState = false;
        isStartState = false;
    }

    /**
     * This method sets a specific state as the Sart State.
     * @param value - True or False based on if the State is or is not the Start State.
     */
    public void setStartState(boolean value) 
    {
        isStartState = value;
    }

    /**
     * This method returns the start state.
     * @return (returns the state where isStartState = true)
     */
    public boolean getStartState() 
    {
        return isStartState;
    }

   /**
    * This method sets a specific state as the End State.
    * @param value - True or False based on if the State is or is not the End State.
    */
    public void setEndState(boolean value) 
    {
        isEndState = value;
    }

    /**
     * This method returns the end state.
     * @return (returns the state where isEndState = true)
     */
    public boolean getEndState() 
    {
        return isEndState;
    }

    /**
     * This method adds a transition to a state
     * @param toState - The resulting state after the transition takes place
     * @param stateSymbol - The value of the transition that takes place
     */
    public void addStateTransition(String toState, Character stateSymbol) 
    {
        // may need to getValue of the stateSymbol
        transitionStates.put(stateSymbol, toState);
    }

    /**
     * This method checks if the Transition is a valid transition.
     * @param transition - The specific transition that is being checked
     * @return (returns boolean of true or false based on validity of transition.)
     */
    public boolean checkValidTransition(Character transition) 
    {
        return transitionStates.containsKey((Character) transition);
    }

    /**
     * This method provides a list of all of the transitions that occurs
     * @return (list of all transitions)
     */
    public LinkedList<Map.Entry<Character, String>> getStateTransitions() 
    {
        LinkedList returnVal = new LinkedList<Map.Entry<Character, String>>();
        for (Entry<Character, String> entry : transitionStates.entrySet())
        {
            returnVal.add(entry);
        }
        return returnVal;
    }
}
