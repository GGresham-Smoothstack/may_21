package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airplane;
import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Flight;

public class AirplaneDAO extends BaseDAO<Airplane>{

	public AirplaneDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	public List<Airplane> readAllAirplanes() throws ClassNotFoundException, SQLException {
		return read("select * from airplane", null);
	}

	@Override
	public List<Airplane> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airplane> airplanes = new ArrayList<>();
		PreparedStatement typePstmt = conn.prepareStatement("SELECT * FROM airplane_type WHERE id = ?" );
		AirplaneTypeDAO airplaneTypeDAO = new AirplaneTypeDAO(conn);
		while (rs.next()) {
			Airplane airplane = new Airplane();
			airplane.setId(rs.getInt("id"));
			typePstmt.setInt(1,rs.getInt("type_id"));
			ResultSet typeSet = typePstmt.executeQuery();
			airplane.setType(airplaneTypeDAO.extractData(typeSet).get(0));
			//airplane.setCityName(rs.getString("city"));
			airplanes.add(airplane);
		}
		
		return airplanes;
	}

}
