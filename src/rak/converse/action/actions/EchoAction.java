package rak.converse.action.actions;

import java.io.IOException;

import rak.converse.main.Communication;

/**
 * Use synonyms to repeat back what the user said in another way
 * @author Austin
 *
 */
public class EchoAction implements Action{
	private String sayText, printText;
	
	
	@Override
	public void buildAction(Communication communication) {
		printText = "Input: " + communication.getInput();
		sayText = "You asked to " + communication.getInput();
		
	}

	@Override
	public void executeAction() {
		
		System.out.println(printText);
		String command = "mshta vbscript:Execute(\"CreateObject(\"\"SAPI.SpVoice\"\").Speak(\"\""+ sayText + "\"\")(window.close)\")";
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
