package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingUser;
import com.ss.utopia.entity.Flight;

public class BookingUserDAO extends BaseDAO{

	public BookingUserDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BookingUser> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingUser> users = new ArrayList<>();
		
		while (rs.next()) {
			BookingUser user = new BookingUser();
			user.setId(rs.getInt("booking_id"));
		}
		// TODO Auto-generated method stub
		return null;
	}

}
