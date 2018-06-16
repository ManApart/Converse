package rak.converse.intent;

import java.util.List;

import edu.stanford.nlp.simple.Sentence;

/**
 * Uses Natural Language Processing to determine the intent of a passed in String
 * @author Austin
 *
 */
public class NaturalLanguageIntentFinder implements IntentFinder {
	
	@Override
	public Intent getIntent(String speech) {
		
		Sentence sent = new Sentence(speech);
		
		List<String> tags = sent.posTags();
		List<String> lemmas = sent.lemmas();
		
		Intent intent = new Intent(sent);
		
		return intent;
	}

}
