package com.ss.utopia.service;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ss.utopia.entity.Airplane;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.Route;

public class AdminServiceTest {
	
	AdminService serv = new AdminService();
	
	@Test
	public void getFlightsTest() {
		
		ArrayList<Flight> flights = new ArrayList<Flight>();
		
		try {
			flights = (ArrayList<Flight>) serv.getAllFlights();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue(false);
		}
		
		assertTrue(flights.size() > 0);
		
	}
	
	@Test
	public void getRoutesTest() {
		
		ArrayList<Route> routes = new ArrayList<Route>();
		
		try {
			routes = (ArrayList<Route>) serv.getAllRoutes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue(false);
		}
		
		assertTrue(routes.size() > 0);
		
	}
	
	@Test
	public void getAirplanesTest() {
		
		ArrayList<Airplane> airplanes = new ArrayList<Airplane>();
		
		try {
			airplanes = (ArrayList<Airplane>) serv.getAllAirplanes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue(false);
		}
		
		assertTrue(airplanes.size() > 0);
		
	}

}
