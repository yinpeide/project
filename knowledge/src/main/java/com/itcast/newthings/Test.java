package com.itcast.newthings;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class Test {

	public static void main(String[] args) throws IOException {
		
		Runtime r = Runtime.getRuntime();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Process p = r.exec("ps");
		InputStream  os =  p.getInputStream();
		byte b[] = new byte[256];
		while(os.read(b)>0){
			baos.write(b);
		}
		String s = baos.toString();
		//System.out.println(s);
		if(s.indexOf("index.js") >=0){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		
				
	}

}
