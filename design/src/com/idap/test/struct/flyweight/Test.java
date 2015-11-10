package com.idap.test.struct.flyweight;

import java.lang.reflect.Constructor;
import java.sql.Connection;

public class Test {

	public static void main(String[] args) throws Exception {
		
		//反射创建pool对象
		
		Class c = Class.forName("com.idap.test.struct.flyweight.ConnectionPool");
		Constructor ctr = c.getDeclaredConstructor();
		//跳过java的权限访问
		ctr.setAccessible(true);
		ConnectionPool cp = (ConnectionPool)ctr.newInstance();//上述代码主要获取类的对象o
		Connection conn = cp.getConnection();
		System.out.println(conn);

	}

}
