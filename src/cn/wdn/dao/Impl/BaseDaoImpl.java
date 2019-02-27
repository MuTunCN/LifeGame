package cn.wdn.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.wdn.util.ConnectionManager;

public abstract class BaseDaoImpl<T>  extends ConnectionManager{
	PreparedStatement psmt;
	ResultSet rs;
	
	

	public Boolean executeUpdate(String sql, Object... params) {
		Connection conn = null;
		try {
			//获得更新结果集
			conn = getConn();
			try {
				//设置事务，取消自动提交
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			psmt = conn.prepareStatement(sql);
			setParams(params);
			if(psmt.executeUpdate()>0) {
				//事务提交
				conn.commit();
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
			try {
				//事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return false;
	}
	public List<T> executeQuery(String sql,Object... params){
		
		try {
			psmt = getConn().prepareStatement(sql);
			setParams(params);
			rs =  psmt.executeQuery();
			return parseResultSet(rs);	
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		
	
		return null;
	}
	private void setParams(Object[] params) {
		try {
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					psmt.setObject(i+1, params[i]);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public abstract List<T> parseResultSet(ResultSet rs);

}