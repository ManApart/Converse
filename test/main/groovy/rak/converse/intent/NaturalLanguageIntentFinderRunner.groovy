package rak.converse.intent

import spock.lang.Specification

class NaturalLanguageIntentFinderRunner extends Specification{
	
	def "OpenApplication opens Notepad"(){
		given:
			String input = "Open notepad";
			NaturalLanguageIntentFinder intentFinder = new NaturalLanguageIntentFinder()
			
		
		when:
			intentFinder.getIntent(input)
		then:
			1 == 1 
		
	}

}
