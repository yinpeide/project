package com.idap.test.struct.proxy;

import org.junit.Test;

public class ProxyTest {

	@Test
	public void testProxy(){
		
		UserService userService = new UserServiceImpl();
		
		MyInvocationHandler invocationHandler =  new MyInvocationHandler(userService);
		
		UserService proxy =  (UserService)invocationHandler.getProxy();
		
		proxy.add();
		
	}
}
