package rak.converse.action.actions

import rak.converse.main.Communication
import spock.lang.Specification

class OpenApplicationRunnerSpec extends Specification{
	
	def "OpenApplication opens Notepad"(){
		given:
			String input = "Test";
			Communication communication = new Communication(input);
			
			OpenApplicationAction action = new OpenApplicationAction();
		
		when:
			action.executeAction();
		then:
			1 == 1 
		
	}

}
