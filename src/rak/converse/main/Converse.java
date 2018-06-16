package rak.converse.main;

import org.apache.commons.lang3.StringUtils;

import rak.converse.action.actions.Action;
import rak.converse.input.SpeechListener;
import rak.converse.intent.Intent;
import rak.converse.intent.IntentFinder;
import rak.converse.intent.context.ContextManager;

public class Converse {
	private SpeechListener speechListener;
	private IntentFinder intentFinder;
	private ContextManager contextManager;
	
	
	public Converse(){
		speechListener = ImplementationMapper.getImplementation(SpeechListener.class);
		intentFinder = ImplementationMapper.getImplementation(IntentFinder.class);
		contextManager = new ContextManager();
	}

	
	public void pollSpeachListener(){
		//Listen for some speech
		String speech = speechListener.getText();
		if (StringUtils.isBlank(speech)){
			return;
		}
		System.out.println("Heard: " + speech);
		
		Communication communication = new Communication(speech);
		
		//Find the intent
		Intent intent = intentFinder.getIntent(speech);
		communication.setIntent(intent);
		System.out.println("Found intent: " + intent);
		
		
		//Build the action
		Action action = contextManager.getCurrentContext().findAction(intent);
		action.buildAction(communication);
		communication.setAction(action);
		System.out.println("Built action: " + communication.getAction());
		
		//Execute the action
		communication.getAction().executeAction();
	}
	
	public ContextManager getContextLoader(){
		return contextManager;
	}
}
