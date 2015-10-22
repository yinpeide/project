package com.itcast.sessionlistener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		//session对象创建的时候执行
			System.out.println("session begin...");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		//这个是session对象销毁的时候执行的
		System.out.println("session ends....");

	}

}
