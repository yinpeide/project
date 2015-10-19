package com.idap.test.create.factoryMethod;

/**
 * Test
 * @author ade
 *
 */
public class Test {
	
	public static void main(String[] args){
		IWorkFactory studentWorkFactory = new StudentWorkFactory();
		studentWorkFactory.getWork().doWork();
	}
}
