package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.Route;

import java.sql.Date;

public class FlightDAO extends BaseDAO<Flight>{

	public FlightDAO(Connection conn) {
		super(conn);
	}
	
	public void addFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("INSERT INTO flight (id, route_id, airplane_id, departure_time, reserved_seats, seat_price) VALUES(?, ?, ?, ?, ?, ?)",
				new Object[] { flight.getId(), flight.getRoute().getId(), flight.getAirplane().getId(), flight.getDeparture_time(), flight.getReservedSeats(), flight.getPrice() });
	}
	
	public void updateFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("UPDATE flight set route_id = ?, airplane_id = ?, departure_time = ?, reserved_seats = ?, seat_price = ? where id = ?", new Object[] {
				flight.getRoute().getId(), flight.getAirplane().getId(), flight.getDeparture_time().toString().split("\\.")[0], flight.getReservedSeats(), Float.toString(flight.getPrice()), flight.getId() });
	}
	
	public void updateFlight(Flight flight, String[] input) throws ClassNotFoundException, SQLException {
		save("UPDATE flight set route_id = ?, airplane_id = ? departure_time = ? reserved_seats = ? seat_price = ? where id = ?", new Object[] {
				input[0], input[1], input[2], input[3], input[4], flight.getId() });
	}
	
	public List<Flight> readAllFlights() throws ClassNotFoundException, SQLException {
		return read("select * from flight", null);
	}

	@Override
	public List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Flight> flights = new ArrayList<>();
		RouteDAO routeDAO = new RouteDAO(conn);
		AirplaneDAO airplaneDAO = new AirplaneDAO(conn);
		PreparedStatement routePstmt = conn.prepareStatement("SELECT * FROM route WHERE id = ?" );
		PreparedStatement airplanePstmt = conn.prepareStatement("SELECT * FROM airplane WHERE id = ?" );
		while (rs.next()) {
			Flight flight = new Flight();
			flight.setId(rs.getInt("id"));
			routePstmt.setInt(1,rs.getInt("route_id"));
			ResultSet routeSet = routePstmt.executeQuery();
			//flight.getRoute().setId(rs.getInt("route_id"));
			//List<Route> temp = ;
			flight.setRoute(routeDAO.extractData(routeSet).get(0));
			airplanePstmt.setInt(1,rs.getInt("airplane_id"));
			ResultSet airplaneSet = airplanePstmt.executeQuery();
			flight.setAirplane(airplaneDAO.extractData(airplaneSet).get(0));
			//flight.getAirplane().setId(rs.getInt("airplane_id"));
			flight.setDeparture_time(rs.getTimestamp("departure_time"));
			//System.out.println(rs.getTimestamp("departure_time"));
			flight.setReservedSeats(rs.getInt("reserved_seats"));
			flight.setPrice(rs.getFloat("seat_price"));
			//route.getOriginAriport().setAirportCode(rs.getString("origin_id"));
			//route.getDestAirport().setAirportCode(rs.getString("destination_id"));
			flights.add(flight);
		}
		return flights;
	}

}
