package com.itcast.newthings;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test01 {

	public static void main(String[] args) {
		final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(16);
		for(int i = 0;i<16;i++){
			final String l = ""+(i+1);
			{
				queue.add(l);
				//Test01.printLog(l);
			}
		}
		for(int i = 0;i<16;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
						try {
							String l = queue.take();
							Test01.printLog(l);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
			}).start();
		}
	}
	
	public static void printLog(String l){
		System.err.println(l +" : "+(System.currentTimeMillis()/1000));
		try{
			Thread.sleep(1000);
		}catch(Exception e){e.printStackTrace();}
	}
}
