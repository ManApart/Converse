package rak.converse.main;

public class Main {
	private static Converse converse;
	
	public static void main(String[] args){
		converse = new Converse();
		
		converse.pollSpeachListener();
		System.out.println("Complete");
	}

	
	public static Converse getConverse(){
		return converse;
	}
}
