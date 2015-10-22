package com.itcast.dwr;

public class UserService {

	public boolean login(String account, String password) {
		System.out.println("UserService>>login() account=" + account);
		return "admin".equals(account) && "admin".equals(password);
	}
}
