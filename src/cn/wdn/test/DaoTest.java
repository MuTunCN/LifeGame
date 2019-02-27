package cn.wdn.test;

import java.util.List;

import cn.wdn.dao.DataDao;
import cn.wdn.dao.Impl.DataDaoImpl;
import cn.wdn.model.Data;
import junit.framework.TestCase;

public class DaoTest extends TestCase {
	DataDao dao;
	
	@Override
	protected void setUp() throws Exception {
		dao = new DataDaoImpl();
	}

	@Override
	protected void tearDown() throws Exception {
		dao = null;
	}
	public void testgetAlldata(){
		List<Data> list = dao.getAlldata();
		System.out.println(list.toString());
		assertNotNull(list);
		
	}
	public void testgetDataByBuff(){
		List<Data> list = dao.getDataByBuff(true);
		assertNotNull(list);
		
	}
	public void testgetDataByAttr(){
		List<Data> list = dao.getDataByAttr("e");
		assertNotNull(list);
		
	}
	public void testgetDataByAge(){
		List<Data> list = dao.getDataByAge(12);
		System.out.println(list.toString());
		assertNotNull(list);
		
	}
	public void testModify(){
		Data data = new Data(12, "33", "3", "3", "e", true);
		boolean f = dao.Modify(data);
		assertEquals(f,true);
		
	}
	public void testInsert(){
		Data data = new Data(12, "33", "3", "3", "e", true);
		boolean f = dao.Insert(data);
		assertEquals(f,true);
	}
	public void testDelete(){
		
		boolean f = dao.Delete(1);
		assertEquals(f,true);
	}
	
}
