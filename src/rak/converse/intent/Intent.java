package rak.converse.intent;

import edu.stanford.nlp.simple.Sentence;

/**
 * Intent includes the parsed Natural Language and the associated Action
 * @author Austin
 *
 */
public class Intent {
	private Sentence sentance;

	public Intent(Sentence sentance) {
		this.sentance = sentance;
	}

	public Sentence getSentance() {
		return sentance;
	}
	
	public boolean isIntent(Sentence sentance){
		return false;
	}

}
