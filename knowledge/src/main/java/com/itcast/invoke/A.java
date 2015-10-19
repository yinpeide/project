/**
 *ade
 *2015年10月19日
 * 
 */
package com.itcast.invoke;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author 尹培德
 * @time 2015年10月19日下午10:18:51
 * 
 * A类通过反射调用私有构造函数的类B的方法
 * AinvokePrivateofBbyreflect
 */
public class A {

	 public static void main(String[] args) {
	  Class<B> cl = B.class;
		  try {
		   Constructor<B> c = cl.getDeclaredConstructor();
		   c.setAccessible(true);
		   B a = c.newInstance();
		   
		   Method m = cl.getDeclaredMethod("print", int.class);
		   m.setAccessible(true);
		   m.invoke(a, 15);
		   
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
	 }
}

final class B{

	 private B(){
	  System.out.println("new B();   OK!");
	 }
	 
	 @SuppressWarnings("unused")
	private void print(int n){
	  System.out.println(n + " is from B!");
	 }
 
}
