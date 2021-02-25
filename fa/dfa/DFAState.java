package fa.dfa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import fa.State;

public class DFAState extends State 
{
    private boolean isEndState, isStartState;
    // Might need to turn State into Character
    private HashMap<State, String> transitionStates;

    // DFA State Constructor
    public DFAState(String name) 
    {
        this.name = name;
        transitionStates = new HashMap<State, String>();
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

    public void addStateTransition(String toState, State stateSymbol) 
    {
        // may need to getValue of the stateSymbol
        transitionStates.put(stateSymbol, toState);
    }

    public boolean checkValidTransition(State transition) 
    {
        return transitionStates.containsKey((State) transition);
    }

    public LinkedList<Map.Entry<State, String>> getStateTransitions() 
    {
        LinkedList returnVal = new LinkedList<Map.Entry<State, String>>();
        for (Entry<State, String> entry : transitionStates.entrySet())
        {
            returnVal.add(entry);
        }
        return returnVal;
    }
}
