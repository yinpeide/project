package com.itcast.quartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuartzJob {
	private static int i = 1;

	public void Mywork() {
		System.out.println("第" + i + "次开始工作...(每隔5秒执行一次)");
		i++;
	}

	// 不用启动项目,直接执行main方法也会开启工作任务
	public static void main(String[] args) {

		System.out.println("----开始---");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring_quartz.xml");

		// 如果配置文件中将startQuertz bean的lazy-init设置为false 则不用实例化

		context.getBean("startQuertz");

		System.out.println("----结束---");

	}
}
