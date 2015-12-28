package com.itcast.newthings;


import java.io.File;
/*
	准备一张表，向这张表中插入10万条记录，但是
	使用批处理操作，记录耗时。
*/
import java.sql.*;
import java.util.List;

import com.itcast.util.ExcelUtils;

public class InertSysfun
{
	public static void main(String[] args){
		Connection conn = null;
		PreparedStatement ps = null;

		try{
			
			//1.注册驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.获取连接
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.168:1521:ideadata","iris_web","iris_web");
			//Class.forName("com.mysql.jdbc.Driver");
			//conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			//3.获取预编译的数据库操作对象
			String sql = "INSERT INTO T02_SYS_FUNCTION(ID,FNAME,FURL,METHOD,REMARK,CONTROLLER,MENUNAME) VALUES(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);

			//4.执行SQL语句
			long begin = System.currentTimeMillis();
			List<String[]>  list = ExcelUtils.readExcel(new File("/Users/ade/test副本.xls"), 1);//从第一行开始
				for(int i=0;i<list.size() ; i++){
					ps.setInt(1, Integer.parseInt(list.get(i)[0]));
					ps.setString(2, list.get(i)[1]);
					ps.setString(3, list.get(i)[2]);
					ps.setString(4, list.get(i)[3]);
					ps.setString(5, list.get(i)[4]);
					ps.setString(6, list.get(i)[5]);
					ps.setString(7, list.get(i)[6]);
					ps.execute();
			}
			
			long end = System.currentTimeMillis();
			System.out.println("耗时："+(end-begin)/1000+"秒");//mysql  25秒
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//5.释放资源
			if(ps!=null){
				try{
					ps.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try{
					conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}