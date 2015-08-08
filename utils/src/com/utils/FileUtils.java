package com.utils;

import java.io.File;

public class FileUtils {
	
	/**
	 * 检查文件是否存在
	 * @param pathname
	 * @return
	 */
	public static boolean checkFile(String pathname){
			File file = new File(pathname);
			return file.exists();
	}
	
//	public static void main(String[] args){
//		System.out.println(FileUtils.checkFile("E:/test.xls"));
//	}
}
