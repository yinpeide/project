/**
 *ade
 *2015年10月21日
 * 
 */
package com.itcast.xpath;

import java.io.File;
import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @author 尹培德
 * @time 2015年10月21日下午10:52:56
 */
public class Dom4jRead {

	public static void main(String[] args)throws Exception {
//		writerFile();
		readXMLFile();
	}
	public static void readXMLFile()throws Exception{
		//创建dom4j提供的SAX解析器对象
		SAXReader reader = new SAXReader();
		//解析student.xml文档获取文档对象
		Document document = reader.read(new File("D:\\student.xml"));
		//读取根节点
		Element rootElement = document.getRootElement();
		//获取姓名节点
		Element nameElement = rootElement.element("姓名");
		//再通过节点获取文本
		String name = nameElement.getText();
		System.out.println(name);
	}
	public static void writerFile()throws Exception{
		//创建文件对象
		Document document = DocumentHelper.createDocument();
		//写入根节点
		Element studentElement = document.addElement("学生");
		//写入子节点
		Element nameElement = studentElement.addElement("姓名");
		//向子节点中写入文本内容
		nameElement.addText("张三");
		//将上面的document内容写入XML文件中
		//先创建一个写文件的对象
		XMLWriter xmlWriter = new XMLWriter(new FileWriter("D:\\student.xml"));
		//写文件
		xmlWriter.write(document);
		//关闭写入文件流
		xmlWriter.close();
		System.out.println("文件写入成功");
	}
	//下面是写XML文件
	/*
	<?xml version="1.0" encoding="GBK"?>

	<学生>
		<姓名>张三</姓名>
	</学生>
	*/
}
