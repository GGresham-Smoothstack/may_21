package com.ss.utopia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadRoutes {
	
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/utopia";
	private static final String username = "root";
	private static final String password = "flpcYxjvvORF6P7wqyBE";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. Register the driver (MySQL)
		Class.forName(driver);
		//2. Connection
		Connection conn = DriverManager.getConnection(url, username, password);
		//3. Statement
		Statement stmt = conn.createStatement();
		String query = "select * from route";
		//4. Execution.
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			System.out.println("Route ID: "+rs.getInt("id"));
			System.out.println("Origin AC: "+rs.getString("origin_id"));
			System.out.println("Dest AC: "+rs.getString("destination_id"));
		}
	}

}