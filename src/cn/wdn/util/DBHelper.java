package cn.wdn.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public  class DBHelper {
	static Connection conn;
	
	static String sqlUrl;
	static String sqlUserName ;
	static String passWord ;
	static String driverName;
	public static Connection getConn(){
		
		Properties p = new DBHelper().GetProperties();
		sqlUrl = (String)p.getProperty("sqlUrl");
		sqlUserName = (String)p.getProperty("sqlUserName");
		passWord =(String) p.getProperty("passWord");
		driverName=(String)p.getProperty("driverName");
		try {
			//注册驱动程序
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			//未找到硬件异常
			System.out.println(e.toString());
			e.printStackTrace();
		}
		try {
			//建立数据库链接
			conn = DriverManager.getConnection(sqlUrl, sqlUserName,passWord );
		} catch (SQLException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return conn;
	}
	public void closeConn(Connection conn){
		if(conn!=null){
			try {
				//关闭连接
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	Properties GetProperties(){
		Properties p = new Properties();
		try {
			
			p.load(getClass().getClassLoader().getResourceAsStream("/sqlConfig.properties"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
}
