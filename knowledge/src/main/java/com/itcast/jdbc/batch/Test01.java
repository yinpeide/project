package com.itcast.jdbc.batch;
/*
	准备一张表，向这张表中插入10万条记录，但是
	不使用批处理操作，记录耗时。
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test01
{
	public static void main(String[] args){
		Connection conn = null;
		PreparedStatement ps = null;

		try{
			
			//1.注册驱动
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.获取连接
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.100:1521:bjpowernode","scott","tiger");
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			//3.获取预编译的数据库操作对象
			String sql = "INSERT INTO BATCH_TAB(ID,NAME) VALUES(?,?)";
			ps = conn.prepareStatement(sql);

			//4.执行SQL语句
			long begin = System.currentTimeMillis();
			for(int i=1;i<=100000;i++){
				ps.setInt(1,i);
				ps.setString(2,"NAME" + i);
				ps.executeUpdate();
			}
			long end = System.currentTimeMillis();
			System.out.println("耗时："+(end-begin)/1000+"秒"); //71秒 mysql 27秒
			
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