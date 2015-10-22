/**
 *ade
 *2015年10月21日
 * 
 */
package com.itcast.util;

import java.lang.reflect.Constructor;

/**
 * @author 尹培德
 * @time 2015年10月21日下午10:23:22
 * 
 * 主要对类的一些操作
 */
public class ClassUtils {
	
	/**
	 * 利用反射创建类的对象(构造函数是私有的也可以)
	 * @param holeClassName
	 * @return
	 */
	public static Object getObjectofClass(String holeClassName){
		try {
			Class c = Class.forName(holeClassName);
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
