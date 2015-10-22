package com.itcast.reflect;

public class A {
	
	private A(){
		System.out.println("A's Consturctor is on");
	}
	private int a;
	private String b;
	private void getIt(int d){
		System.out.println("The value is "+d);
	}
}
