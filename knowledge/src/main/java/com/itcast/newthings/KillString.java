package com.itcast.newthings;


import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;

public class KillString {

	public static void main(String[] args) throws DocumentException, UnsupportedEncodingException {
		
		String s = "<a href=\"\" id=\"contact_phone2\" class=\"job-sub-phone\" phoneno=\"17751535254\" tongji_tag=\"telephone_num&amp;entityId=24117190545077&amp;entityType=0&amp;psid=150250972190096379512349233\"><span class=\"phone_icon\"></span>电话咨询</a>";
		Document document = DocumentHelper.parseText(s); 
		System.out.println(document.getRootElement().attributeValue("phoneno"));
	}

}
