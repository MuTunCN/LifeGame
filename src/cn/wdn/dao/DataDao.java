package cn.wdn.dao;

import java.util.List;

import cn.wdn.model.Data;

public interface DataDao {
	List<Data> getAlldata();
	List<Data> getDataByAge(int age);
	List<Data> getDataByAttr(String attr);
	List<Data> getDataByBuff(boolean buff);
	List<Data> getDataById(int id);
	boolean Delete(int id);
	boolean Modify(Data data);
	boolean Insert(Data data);
}
