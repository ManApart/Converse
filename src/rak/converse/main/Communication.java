package rak.converse.main;

/**
 * Contains all relevant pieces of the communication
 */
import rak.converse.action.actions.Action;
import rak.converse.intent.Intent;

public class Communication {
	private String input;
	private Intent intent;
	private Action action;
	
	
	public Communication(String input){
		this.input = input;
	}
	
	public String getInput() {
		return input;
	}

	public Intent getIntent() {
		return intent;
	}
	public void setIntent(Intent intent) {
		this.intent = intent;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	
//	public void setInput(String input) {
//		this.input = input;
//	}
	
	
	
}
