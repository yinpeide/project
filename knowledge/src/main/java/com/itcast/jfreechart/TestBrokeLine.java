package com.itcast.jfreechart;

import org.jfree.ui.RefineryUtilities;
import org.junit.Before;
import org.junit.Test;

public class TestBrokeLine {
	
	private Picture pic = null;
	
	@Before
	public void InitMethod(){
		pic = new Picture();
	}
	
	//获取客户端的折线图
	@Test
	public void getBrokeLine() {
		 BrokeLine fjc = new BrokeLine("折线图");
		 fjc.pack();
		 RefineryUtilities.centerFrameOnScreen(fjc);
		 fjc.setVisible(true);
	}
	
	//在电脑上生成折现图片
	@Test
	public void  getBar(){
		pic.createBarDemo("/Users/ade/Downloads/d/bar.jpg");
	}
	
	//在电脑上生成饼图图片
	public void getPie(){
		pic.createPieDemo("/Users/ade/Downloads/d/pie.jpg");	
	}
}
