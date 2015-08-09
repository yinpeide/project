/**
 *ade
 *2015年8月4日
 * 
 */
package com.itcast.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 尹培德
 * @time 2015年8月4日下午11:53:09
 */
public class DateUtils {

	/**
	 * 获取系统时间
	 * @return
	 */
	public static String getSystemTime() {
		//return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		return format(new Date());
	}
	
	/**
	 * 格式化时间
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
	
//	public static void main(String args[]){
//		System.out.println(DateUtils.getSystemTime());
//	}
}
