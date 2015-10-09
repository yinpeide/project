package com.itcast.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.AcroFields.Item;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PdfUtils {
	
	/**
	 * 给模板pdf文件赋值  pdf需要提前编辑 adobe acrobat 
	 * @param template
	 * @param outpath
	 * @param datas
	 */
	public static void export(String template, String outpath,Map<String, Object> datas) {
		PdfStamper stamper = null;
		PdfReader reader = null;
		try {
			reader = new PdfReader(template);
			stamper = new PdfStamper(reader, new FileOutputStream(outpath));
			AcroFields form = stamper.getAcroFields();
			Map<String, Item> fieldMap = form.getFields(); // pdf表单相关信息展示
			for (Map.Entry<String, Item> entry : fieldMap.entrySet()) {
				String key = entry.getKey(); // name就是pdf模版中各个文本域的名字
				System.out.println("[key]:" + key + ", [value]: "
						+ entry.getValue());
				if (datas.containsKey(key)) {
					if(null != datas.get(key)){
						form.setField(key, datas.get(key).toString());	
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stamper.close();
				reader.close();
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

//	
//	public static void main(String[] args) throws Exception {
//		HashMap<String, Object> datas = new HashMap<String, Object>();
//		datas.put("fill_1", "数据分析平台测试数据分析平台测试");
//		datas.put("fill_2", "数据分析平台测试数据分析平台测试");
//		datas.put("fill_3", "数据分析平台测试数据分析平台测试");
//		datas.put("fill_4", "数据分析平台测试数据分析平台测试");
//		datas.put("fill_5", "数据分析平台测试数据分析平台测试");
//		datas.put("fill_6", "数据分析平台测试数据分析平台测试");
//		PdfUtils.export("D:\\test.pdf", "D:\\test01.pdf", datas);
//	}
}
