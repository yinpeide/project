package com.idap.test.create.singleton;

/**
 * 单例模式
 * @author ade
 *
 */
public class Singleton {
	private Singleton(){}
	private static Singleton singleton;
	public static Singleton getSingleton(){
		if(singleton == null){
			singleton =  new Singleton();
		}
		return singleton;
	}
}
