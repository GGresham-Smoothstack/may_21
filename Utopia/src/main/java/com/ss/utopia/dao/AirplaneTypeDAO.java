package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.AirplaneType;
import com.ss.utopia.entity.Airport;

public class AirplaneTypeDAO extends BaseDAO<AirplaneType>{

	public AirplaneTypeDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<AirplaneType> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<AirplaneType> airplaneTypes = new ArrayList<>();
		while (rs.next()) {
			AirplaneType type = new AirplaneType();
			type.setId(rs.getInt("id"));
			type.setMaxCapacity(rs.getInt("max_capacity"));
			airplaneTypes.add(type);
		}
		return airplaneTypes;
	}

}
