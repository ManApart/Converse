package rak.converse.intent;

import rak.converse.action.actions.OpenApplicationAction;

public class MockIntentFinder implements IntentFinder{

	@Override
	public Intent getIntent(String speech) {
		Intent intent = new Intent(null);
		
		return intent;
	}

}
