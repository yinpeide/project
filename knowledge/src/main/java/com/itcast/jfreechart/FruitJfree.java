package com.itcast.jfreechart;

import java.awt.Font;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

public class FruitJfree extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置响应类型，不再是 text/html，要响应一个图片。
		response.setContentType("image/jpeg");
		// 创建数据的集合
		DefaultCategoryDataset dataset = getBarDataset();
		/*
		 * createBarChart3D创建柱图，第一个参数是图标的标题，第二个是X轴标题，第三个是Y轴标题，第四个是数据集合，
		 * PlotOrientation.HORIZONTAL , 图表方向：水平PlotOrientation.VERTICAL ,
		 * 图表方向：垂直 false, 是否显示图例(对于简单的柱状图必须是false),生成在图片的最下方，该例中表示什么颜色代表什么地方。
		 * true, 是否生成工具 true 是否生成URL链接
		 * 
		 */
		JFreeChart chart = ChartFactory.createBarChart3D("水果产量图", "水果", "产量",
				dataset, PlotOrientation.VERTICAL, true, false, false);
		// 获取柱状图的plot的对象
		CategoryPlot plot = chart.getCategoryPlot();
		// 获得标题类，设置标题的字体颜色大小
		TextTitle textTitle = chart.getTitle();
		// 取得纵轴
		NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();
		// PLAIN字体样式为普通， BOLD字体样式为粗体
		textTitle.setFont(new Font("黑体", Font.BOLD, 30));
		// 取得横轴
		CategoryAxis domainAxis = plot.getDomainAxis();
		//设置柱状图整体距离y轴左侧10%
		domainAxis.setLowerMargin(0.1);
		//设置柱状图整体距离y轴右侧10%
		domainAxis.setUpperMargin(0.1);
		//设置X轴与X轴标签之间的距离为1个像素   setCategoryMargin设置距离百分比
		domainAxis.setCategoryLabelPositionOffset(1);
		// 设置横轴标尺值字体
		domainAxis.setTickLabelFont(new Font("sans-serif", Font.BOLD, 22));
		// 设置横轴显示标签的字体
		domainAxis.setLabelFont(new Font("宋体", Font.BOLD, 18));
		// 设置纵轴标尺值字体
		numberaxis.setTickLabelFont(new Font("sans-serif", Font.BOLD, 22));
		// 设置纵轴显示标签字体
		numberaxis.setLabelFont(new Font("黑体", Font.BOLD, 18));
		// char.getLegend 取得表的第一个图例，设置图例的字体
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 22));
		/*
		 * 第一个参数是输出流对象，第二个是分辨率 介于0.1F到1.0F之间 第三个是chart对象（图像作为输出流进行输出）
		 * 第四个第五个是图片大小的设置。
		 * 
		 */
		ChartUtilities.writeChartAsJPEG(response.getOutputStream(), 1.0f, chart, 900, 700,null);
		
	}
	
	// 获取柱状图数据
	private DefaultCategoryDataset getBarDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// 往dataset中加入数据，第一个参数是y轴坐标，第三个参数是x轴坐标，第二个参数是每个参量
		dataset.addValue(33, "北京", "苹果");
		dataset.addValue(55, "上海", "梨子");
		dataset.addValue(77, "南昌", "葡萄");
		dataset.addValue(13, "海南", "香蕉");
		dataset.addValue(28, "北京", "荔枝");
		dataset.addValue(65, "上海", "荔枝");
		return dataset;
	}	
}
