package com.idap.test.create.factoryMethod;

/**
 * ConcreteCtrator
 * @author ade
 *
 */
public class StudentWorkFactory implements IWorkFactory{
	public Work getWork(){
		return new StudentWork();
	}
}
