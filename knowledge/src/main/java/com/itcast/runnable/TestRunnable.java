package com.itcast.runnable;

public class TestRunnable {

    public static void main(String[] args) {
              //创建对象
              MyRunnable mr = new MyRunnable();
              Thread t = new Thread(mr);
              //启动
              t.start();
              try{
            	  System.out.println("main方法执行");
              }catch(Exception e){}
    }

}