package rak.converse.intent.responseMap;

import rak.converse.action.actions.Action;
import rak.converse.action.actions.EchoAction;
import rak.converse.intent.Intent;

public class EchoResponse extends Response {



	@Override
	public boolean fitsIntent(Intent intent) {
		return true;
	}

	@Override
	protected Class<? extends Action> getActionClass() {
		return EchoAction.class;
	}

}
