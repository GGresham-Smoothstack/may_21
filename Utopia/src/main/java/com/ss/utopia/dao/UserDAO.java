package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.User;

public class UserDAO extends BaseDAO{

	public UserDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<User> users = new ArrayList<>();
		PreparedStatement roleP = conn.prepareStatement("SELECT * FROM user_role WHERE id = ?" );
		UserRoleDAO roles = new UserRoleDAO(conn);
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			
			roleP.setInt(1,rs.getInt("role_id"));
			user.setRole(roles.extractData(roleP.executeQuery()).get(0));
			
			user.setGivenName(rs.getString("given_name"));
			user.setFamilyName(rs.getString("family_name"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			
			users.add(user);
		}
		
		return users;
	}

}
