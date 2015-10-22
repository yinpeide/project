/**
 *ade
 *2015年10月21日
 * 
 */
package com.itcast.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import junit.framework.TestCase;

	public class Test extends TestCase{
		
		//用反射调用类A的构造方法
		public void testConstructor(){
			try {
				//获取类的对象
				//Class c = Class.forName("com.de.test.A");
				getObjectofClass();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//用反射调用类A的私有方法
		public void testMethod(){
			try {
				Class c = Class.forName("com.itcast.reflect.A");
				Object o = getObjectofClass();
				Method method = c.getDeclaredMethod("getIt", int.class);
				//跳过java的权限访问
				method.setAccessible(true);
				method.invoke(o,4);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//用反射访问类A的成员变量
		public void testField(){
			try {
				Class c = Class.forName("com.itcast.reflect.A");
				Object o = getObjectofClass();
				Field field = c.getDeclaredField("a");
				field.setAccessible(true);
				field.set(o,2);
				System.out.println(field.get(o));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public Object getObjectofClass(){
			try {
				Class c = Class.forName("com.itcast.reflect.A");
				Constructor ctr = c.getDeclaredConstructor();
				//跳过java的权限访问
				ctr.setAccessible(true);
				return ctr.newInstance();//上述代码主要获取类的对象o
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}