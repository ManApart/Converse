package rak.converse.input;

import java.util.ArrayList;
import java.util.List;

public class MockSpeechListener implements SpeechListener {
	private List<String> strings = new ArrayList<>();
	
	public MockSpeechListener() {
		strings.add("Open Notepad");
	}
	
	@Override
	public String getText() {
		return strings.get(0);
	}
	

}
