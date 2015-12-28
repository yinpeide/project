package com.itcast.newthings;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class InsertFile {

	public static void main(String[] args) throws IOException {
		File file = new File("/Users/ade/new.txt");
		if(!file.exists()){
			file.createNewFile();
		}
	}

}
