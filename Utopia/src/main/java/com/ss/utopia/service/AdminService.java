package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.dao.AirplaneDAO;
import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.RouteDAO;
import com.ss.utopia.entity.Airplane;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.Route;

public class AdminService {
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void addFlight(Flight flight) throws SQLException {
		Connection conn = null;
		
		try {
			conn = connUtil.getConnection();
			FlightDAO dao = new FlightDAO(conn);
			dao.addFlight(flight);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
	}
	
	public List<Flight> getAllFlights() throws SQLException{
		Connection conn = null;
		List<Flight> flights = new ArrayList<>();
		
		try {
			conn = connUtil.getConnection();
			FlightDAO dao = new FlightDAO(conn);
			flights = dao.readAllFlights();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
		return flights;
	}
	
	public List<Airplane> getAllAirplanes() throws SQLException{
		Connection conn = null;
		List<Airplane> planes = new ArrayList<>();
		
		try {
			conn = connUtil.getConnection();
			AirplaneDAO dao = new AirplaneDAO(conn);
			planes = dao.readAllAirplanes();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
		return planes;
	}
	
	public List<Route> getAllRoutes() throws SQLException {
		Connection conn = null;
		List<Route> routes = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			routes = rdao.readAllRoutes();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return routes;
	}
	
	public void addFlight() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			//> aiportDao.save(IAD)
			  //> aiportDao.save(CDG)
//			  > airplaneDAO.save()
	//		  > flightDAO.save()
			conn.commit(); //this makes the change permanent. 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
}