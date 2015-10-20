package com.itcast.jfreechart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 * 显示企业投资人的投资比例饼状图
 * @author Administrator
 */
public class ViewInvScaleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置响应类型，不再是 text/html，要响应一个图片。
		response.setContentType("image/jpeg");
		
		// 获取数据集
		DefaultPieDataset data = getDataSet();
		
		// 生成图表对象
		JFreeChart chart = ChartFactory.createPieChart3D(
				"显示投资人饼状图",
				data,
				true,
				false,
				false
		);
		
		//向浏览器输出饼状图
		ChartUtilities.writeChartAsJPEG(response.getOutputStream(),1.0f,chart,400,300,null);
	}
	
	/**
	 * 获取数据集
	 * @return
	 */
	//这个getDataSet可以传递参数，这样就可以从数据库里面查询数据了
	private DefaultPieDataset getDataSet() {
		DefaultPieDataset dataset = new DefaultPieDataset();
			dataset.setValue("IBM",1000);
			dataset.setValue("谷歌", 2000);
			dataset.setValue("百度", 3000);
		return dataset;
	}
}