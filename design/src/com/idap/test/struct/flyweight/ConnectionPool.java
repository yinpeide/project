package com.idap.test.struct.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ConnectionPool {
	 
	private Vector<Connection> pool;
	
	 // 公用属性
	 private String url = "jdbc:mysql://localhost:3306/mydb";
	 private String username = "root";
	 private String password = "root";
	 private String driverClassName = "com.mysql.jdbc.Driver";
	 
	 //连接池的属性
	 private int poolSize = 50;  
	    private static ConnectionPool instance = new ConnectionPool();  
	   
	    // 初始化连接池
	    private ConnectionPool() {
	     pool = new Vector<Connection>();
	     for (int i = 0; i < poolSize; i++) {
		      try {
			    Class.forName(driverClassName);
			    Connection conn = DriverManager.getConnection(url, username, password);
			    pool.add(conn);
			   } catch (Exception e) {
			    e.printStackTrace();
			   }
		     }
	    }
	   
	    public Connection getConnection() {
	     Connection conn = pool.get(0);
	     pool.remove(conn);
	     return conn;
	    }
	   
	    public void realese(Connection conn) {
	     pool.add(conn);
	    }
	   
	    public static ConnectionPool getInstance() {
	     return instance;
	    }
	}
