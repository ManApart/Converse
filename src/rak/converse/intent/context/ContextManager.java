package rak.converse.intent.context;

import java.util.ArrayList;
import java.util.List;

import rak.converse.intent.responseMap.EchoResponse;

/**
 * Loads all contexts and their Intents. Will eventually use property files but hard coding for now to move faster
 * @author Austin
 *
 */
public class ContextManager {
	List<Context> contexts = new ArrayList<>(); 
	private Context currentContext;
	
	public ContextManager(){
		try {
			loadAllContexts();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private void loadAllContexts() throws InstantiationException, IllegalAccessException {
		Context context = new Context();
		
		context.addResponse(new EchoResponse());
		contexts.add(context);
		
		currentContext = context;
	}


	public Context getCurrentContext() {
		return currentContext;
	}
	

}
