package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.UserRole;

public class UserRoleDAO extends BaseDAO{

	public UserRoleDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<UserRole> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<UserRole> roles = new ArrayList<>();
		
		while (rs.next()) {
			UserRole role = new UserRole();
			role.setId(rs.getInt("id"));
			role.setName(rs.getString("name"));
			roles.add(role);
		}
		
		return roles;
	}

}
