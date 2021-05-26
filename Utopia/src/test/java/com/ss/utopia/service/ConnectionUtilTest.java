package com.ss.utopia.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionUtilTest {
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	@Test
	public void getConnectionTest() {
		Connection conn = null;
		
		try {
			conn = connUtil.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue(false);
		}
		
		assertFalse(conn == null);
		
	}
	
	@Test
	public void getPropertyTest() {
		String test = connUtil.getProperty("driver");
		
		assertTrue(test.equals("com.mysql.cj.jdbc.Driver"));
	}

}
