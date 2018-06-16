package rak.converse.action.actions;

import rak.converse.main.Communication;

/**
 * Contains a subsequent faction that is independent of intent. Intent explains the wishes of the user, the action is the computer's response.
 * @author Austin
 *
 */
public interface Action {

	void buildAction(Communication communication);

	void executeAction();

}
