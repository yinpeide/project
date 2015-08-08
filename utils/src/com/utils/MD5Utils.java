/**
 *ade
 *2015年8月4日
 * 
 */
package com.utils;

import java.security.MessageDigest;

/**
 * @author 尹培德
 * @time 2015年8月4日下午11:34:17
 */
public class MD5Utils {
	
	public final static String md5(String s) {
		try {
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < md.length; i++) {
				int val = ((int) md[i]) & 0xff;
				if (val < 16)
					sb.append("0");
				sb.append(Integer.toHexString(val));
			}
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}
	
//	public static void main(String[] args){
//		System.out.println(MD5Utils.md5("9"));
//	}
}
