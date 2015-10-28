package com.itcast.jdbc;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.itcast.util.DateUtils;
import com.itcast.util.ExcelUtils;

import jxl.read.biff.BiffException;

public class excel2db {
	public static Connection jdbc() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.108:1521:orcl", "sjfx", "sjfx");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String args[]) throws ParseException {
		String sql = "insert into JDBC_TEST(text,name,age,birthday,remark) values(?,?,?,?,?)";
		Connection con = jdbc();
		try {
			con.setAutoCommit(false);
			String excelFileName = "/Users/ade/Downloads/jdbcTest.xls";
			List<String[]> list = ExcelUtils.readExcel(new File(excelFileName), 2);
			int i=0;
			for(String[] strAttr : list){
				PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
				for(int j=0;j<strAttr.length;j++){
					if(0==j){
						InputStream inputStream = new ByteArrayInputStream(strAttr[j].getBytes("utf-8"));
						pstmt.setBlob(j+1, inputStream);
					}else if(2==j){
						if ( null != strAttr[j] && strAttr[j].trim().length() > 0) {
							pstmt.setInt(j+1, Integer.parseInt(strAttr[j]));
						} else {
							pstmt.setInt(j+1, 0);
						}
					}else if(3==j){
						if (null !=strAttr[j]  && strAttr[j].trim().length() > 0) {
							pstmt.setDate(j+1, new java.sql.Date(DateUtils.strToDate(strAttr[j], new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).getTime()));
						} else {
							pstmt.setDate(j+1, null);
						}
					}else{
						pstmt.setString(j+1, strAttr[j]);
					}
				}
				i++;
				System.out.println(i);
				pstmt.execute();
				con.commit();
				pstmt.close();
				
			}
			con.commit();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
