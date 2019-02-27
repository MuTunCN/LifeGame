package cn.wdn.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;

public class ConnectionManager {
	ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>(){

		@Override
		protected Connection initialValue() {
			Connection conn = DBHelper.getConn();
			return conn;
		}
		
	};
	public Connection getConn(){
		return threadLocal.get();
	}
	public void closeConn(){
		Connection conn = threadLocal.get();
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
