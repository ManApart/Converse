package rak.converse.action.actions;

import java.io.IOException;

import rak.converse.main.Communication;

public class OpenApplicationAction implements Action{
	private String applicationPath = "C:\\WINDOWS\\system32\\notepad.exe";

	@Override
	public void buildAction(Communication communication) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeAction() {
		
		//get name of application they want to open
		
		//Find application path
		
		//run application
		try {
			openApplication();
		} catch (IOException e) {
			// TODO Eventually Move error handling out of actions
			e.printStackTrace();
		}
		
	}

	private void openApplication() throws IOException {
		Process process = new ProcessBuilder(applicationPath).start();
	}


}
