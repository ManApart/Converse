package rak.converse;

import java.io.IOException;

public class Doodle {
	
	public static void main(String[] args){
		String command = "mshta vbscript:Execute(\"CreateObject(\"\"SAPI.SpVoice\"\").Speak(\"\"Hello\"\")(window.close)\")";
//		String command = "cmd /c start notepad++.exe";
		speechThroughClassicCMD(command);
		
		
	}

	private static void speechThroughClassicCMD(String command) {
		try {
			Process runtime = Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
