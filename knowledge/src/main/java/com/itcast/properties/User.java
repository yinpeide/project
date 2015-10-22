package com.itcast.properties;

public class User {
	String username;
	
	public User(){
		System.out.println("无参数的构造函数执行");
	}

	public User(String username){}

	public String toString(){
		return "User[username=" + username + "]";
	}
}
