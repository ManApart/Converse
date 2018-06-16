package rak.converse.intent.responseMap;

import rak.converse.action.actions.Action;
import rak.converse.intent.Intent;

/**
 * The link between an intent and the action the computer will take
 * @author Austin
 *
 */
public abstract class Response {
	private Class<? extends Action> actionClass;
	
	public Response() {
		this.actionClass = getActionClass();
		
		//If this action can't be initialized, let's throw the erorr it right away.
		try {
			actionClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Action getAction(){
		Action action = null;
		try {
			action = actionClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return action;
	}
	
	public abstract boolean fitsIntent(Intent intent);
	protected abstract Class<? extends Action> getActionClass();
	
	
	
}
