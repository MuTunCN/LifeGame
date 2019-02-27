package cn.wdn.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.wdn.dao.DataDao;
import cn.wdn.model.Data;
import cn.wdn.util.ConnectionManager;

public class DataDaoImpl extends BaseDaoImpl<Data> implements DataDao{
	@Override
	public List<Data> getAlldata() {
		String sql = "select * from life";
		return executeQuery(sql);
	}

	@Override
	public List<Data> getDataByAge(int age) {
		String sql = "select * from life where age = ?";
		return executeQuery(sql, age);
	}

	@Override
	public List<Data> getDataByAttr(String attr) {
		String sql = "select * from life where attr = ?";
		return executeQuery(sql, attr);
	}

	@Override
	public List<Data> getDataByBuff(boolean buff) {
		String sql = "select * from life where buff = ?";
		return executeQuery(sql, buff);
	}

	@Override
	public boolean Modify(Data data) {
		String sql = "update  life set age =?, content=?, shortcon=? ,title=?, attr=?,  buff=? where id  = ?";
		return executeUpdate(sql, data.getAge(),data.getContent(),data.getShortCon(),data.getTitle(),data.getAttr(),data.getBuff(),data.getId());
		
	}

	@Override
	public boolean Delete(int id) {
		String sql = "delete from life where id=?";
		return executeUpdate(sql, id);
	}

	@Override
	public boolean Insert(Data data) {
		String sql = "insert  life values(?,?,?,?,?,?,?)";
		return executeUpdate(sql, null,data.getAge(),data.getContent(),data.getShortCon(),data.getTitle(),data.getAttr(),data.getBuff());
	}

	@Override
	public List<Data> parseResultSet(ResultSet rs) {
		List<Data> list = new ArrayList<Data>();
		try {
		while(rs.next()){
			int id = rs.getInt(1);
			int age = rs.getInt(2);
			String content = rs.getString(3);
			String shortCon = rs.getString(4);
			String title = rs.getString(5);
			String attr = rs.getString(6);
			boolean buff = rs.getBoolean(7);
			
			Data data  = new Data(id, age, content, shortCon, title, attr, buff);
			list.add(data);
			
		}
		return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Data> getDataById(int id) {
		String sql = "select * from life where id = ?";
		return executeQuery(sql, id);
	}

	

	
	
}
