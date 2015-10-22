/**
 *ade
 *2015年10月21日
 * 
 */
package com.itcast.xpath;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * @author 尹培德
 * @time 2015年10月21日下午10:54:15
 */
public class XpathRead {
	public static void main(String[] args)throws Exception{
		readXMLFilerByXpath2();
	}
	public static String readXMLFileByXpath1()throws Exception{
		//获取sax解析对象
		SAXReader reader = new SAXReader();
		//获取文件对象
 		Document document = reader.read(new File("D:\\db-config-ext.xml"));
		String xPath = "/db-config/db-type";
		//根据xPath获取某个特定的节点对象
		Node node = document.selectSingleNode(xPath);
		System.out.println(node.getText());
		return node.getText();
		}
	public static void readXMLFilerByXpath2()throws Exception{
		String type = readXMLFileByXpath1();
		//下面要求获取一组xPath
		String xPath = "/db-config/db[@type='"+type+"']";
		//获取这一组节点
		Element dbElement = (Element)new SAXReader().read(new File("D:\\db-config-ext.xml")).selectSingleNode(xPath);
		//获取这些文本
		String driverClass = dbElement.elementText("driver-class");
		//输出文本的内容
		System.out.println(driverClass);
	}
}
