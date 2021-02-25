package fa.dfa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import fa.State;

public class DFAState extends State 
{
    private boolean isEndState, isStartState;
    // Might have remaining States that need to be Character
    private HashMap<Character, String> transitionStates;

    // DFA State Constructor
    public DFAState(String name) 
    {
        this.name = name;
        transitionStates = new HashMap<Character, String>();
        isEndState = false;
        isStartState = false;
    }

    public void setStartState(boolean value) 
    {
        isStartState = value;
    }

    public boolean getStartState() 
    {
        return isStartState;
    }

    public void setEndState(boolean value) 
    {
        isEndState = value;
    }

    public boolean getEndState() 
    {
        return isEndState;
    }

    public void addStateTransition(String toState, Character stateSymbol) 
    {
        // may need to getValue of the stateSymbol
        transitionStates.put(stateSymbol, toState);
    }

    public boolean checkValidTransition(Character transition) 
    {
        return transitionStates.containsKey((Character) transition);
    }

    public LinkedList<Map.Entry<State, String>> getStateTransitions() 
    {
        LinkedList returnVal = new LinkedList<Map.Entry<Character, String>>();
        for (Entry<Character, String> entry : transitionStates.entrySet())
        {
            returnVal.add(entry);
        }
        return returnVal;
    }
}
