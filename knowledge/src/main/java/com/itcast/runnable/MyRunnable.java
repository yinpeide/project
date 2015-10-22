package com.itcast.runnable;

public class MyRunnable implements Runnable {

    public void run() {
    				try {
						Thread.sleep(3000L);
						System.out.println("run方法执行");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    }
}