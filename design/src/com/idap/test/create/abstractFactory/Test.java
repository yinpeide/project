package com.idap.test.create.abstractFactory;

public class Test {

	public static void main(String[] args) {
		IAnimalFactory blackFactory = new BlackAnimalFactory();
		IAnimalFactory whileFactory = new WhileAnimalFactory();
		blackFactory.createCat().eat();
		whileFactory.createCat().eat();
	}
}
