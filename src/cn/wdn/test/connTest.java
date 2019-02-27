package cn.wdn.test;

import java.sql.Connection;

import cn.wdn.util.DBHelper;
import junit.framework.TestCase;

public class connTest extends TestCase{

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	public void testGetConn(){
		Connection conn = DBHelper.getConn();
		this.assertNotNull(conn);
	}
}
