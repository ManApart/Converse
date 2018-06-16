package rak.converse.intent.context;

import java.util.ArrayList;
import java.util.List;

import rak.converse.action.actions.Action;
import rak.converse.intent.Intent;
import rak.converse.intent.responseMap.Response;

/**
 * A Context provides a list of intents that are relevant to the current state 
 * @author Austin
 *
 */
public class Context {
	private List<Response> responses = new ArrayList<>();
	
	public void addResponse(Response response){
		responses.add(response);
	}

	public Action findAction(Intent intent) {
		List<Action> eligibleActions = new ArrayList<>();
		
		//Finad all actions
		for (Response response : responses){
			if (response.fitsIntent(intent)){
				eligibleActions.add(response.getAction());
			}
		}
		
		//Error Handling
		if (eligibleActions.size() == 0){
			System.out.println("No actions found for " + intent);
			return null;
		} else if (eligibleActions.size() > 1){
			System.out.println("Multiple Actions found for " + intent);
			for (Action action : eligibleActions){
				System.out.println("Found " + action);
			}
			//TODO - in the future give the user a choice which action to use.
		}
		
		//Return the action
		return eligibleActions.get(0);
	}

}
