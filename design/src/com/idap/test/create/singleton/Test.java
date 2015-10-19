package com.idap.test.create.singleton;

public class Test {

	public static void main(String[] args) {
		Singleton singleton1 = Singleton.getSingleton();
		Singleton singleton2 = Singleton.getSingleton();
		System.out.println(singleton1);
		System.out.println(singleton2);
	}

}
