package com.nt.ston;

public class Printer {

	private static Printer INSTATNCE;
	
	public Printer() {
		System.out.println("Printer :: 0-param Constructor)");
	}
	
	//static factory method
	public static Printer getInstance() {
		if(INSTATNCE==null) {
			INSTATNCE=new Printer();
			
		}
	   	return INSTATNCE;
	
		}
	public void print(String msg) {	
		
	  }

	
}
