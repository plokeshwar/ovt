package com.overture.npc.testcases;

public class Awesome {
	
	public static void pravinGreat(){
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
		
		
	}
	
	public static void main(String[] args) {
		System.out.println("Rini");
		pravinGreat();
		System.out.println(getMethodName(2));
	}

	public static String getMethodName(final int depth)
	{
	  final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
	  //System. out.println(ste[ste.length-depth].getClassName()+"#"+ste[ste.length-depth].getMethodName());
	  // return ste[ste.length - depth].getMethodName();  //Wrong, fails for depth = 0
	  return ste[ste.length - 1 - depth].getMethodName(); //Thank you Tom Tresansky
	}
	
}
