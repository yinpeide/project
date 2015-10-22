package com.itcast.properties;

import java.io.FileReader;
import java.util.Properties;

public class Test {
	
	public static void main(String[] args) throws Exception{
		
		String filePath = Thread.currentThread().getContextClassLoader().getResource("").toString().substring(5) ;
		
		System.out.println(filePath);
		//创建属性类对象
		Properties pro = new Properties();
		//创建流
		FileReader reader = new FileReader(filePath +"/config/classInfo.properties");
		//加载
		pro.load(reader);
		//关闭流
		reader.close();
		//通过key获取value
		String className = pro.getProperty("classname");
		//System.out.println("类名是：" + className);
		//通过反射机制创建java对象
		Class c = Class.forName(className);
		Object o = c.newInstance();
		System.out.println(o);
	}
}
