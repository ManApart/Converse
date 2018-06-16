package rak.converse.main;

import java.util.HashMap;

import rak.converse.input.MockSpeechListener;
import rak.converse.input.SpeechListener;
import rak.converse.intent.IntentFinder;
import rak.converse.intent.MockIntentFinder;

public class ImplementationMapper {
	
	private static ImplementationMapper INSTANCE = new ImplementationMapper();
	
	
	private HashMap<Class, Object> implementationMap;
	
	
	private ImplementationMapper() {
		try {
			implementationMap = loadImplementationMap();
		} catch (ImplementationMappingException e) {
			throw new RuntimeException(e);
		}
	}

	
	//TODO Replace this with load from config file
	private HashMap<Class, Object> loadImplementationMap() throws ImplementationMappingException{
		HashMap<Class, Object> map = new HashMap<Class, Object>();
		addMapping(map, SpeechListener.class, MockSpeechListener.class);
		addMapping(map, IntentFinder.class, MockIntentFinder.class);
		
		return map;
	}
	
	private void addMapping(HashMap<Class, Object> map, Class interfaceClass, Class implementationClass) throws ImplementationMappingException{
		if (!interfaceClass.isInterface()){
			throw new ImplementationMappingException(interfaceClass + " is not a valid interface");
		}
		
		if (!interfaceClass.isAssignableFrom(implementationClass)){
			throw new ImplementationMappingException(implementationClass + " is not a valid implmentation for " + interfaceClass);
		}
		
		try {
			map.put(interfaceClass, implementationClass.newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			throw new ImplementationMappingException("Unable to create " + implementationClass + " implementation for " + interfaceClass);
		}
		
	}
	
	public static <T> T getImplementation(Class<T> interfaceClass){
		if (!INSTANCE.implementationMap.containsKey(interfaceClass)){
			throw new RuntimeException("No Implmentation for " + interfaceClass);
		}
		return (T) INSTANCE.implementationMap.get(interfaceClass);
	}
	
}
