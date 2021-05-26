package com.ss.utopia.jdbc;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

import com.ss.utopia.dao.AirplaneDAO;
import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.RouteDAO;
import com.ss.utopia.entity.Airplane;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.Route;
import com.ss.utopia.service.AdminService;

public class AdminMenu extends Menu{
	
	private Connection conn;
	
	private AdminService serv;
	
	public void process(Scanner input) throws SQLException, ClassNotFoundException {
		
		Class.forName(UtopiaMain.getDriver());
		//2. Connection
		conn = DriverManager.getConnection(UtopiaMain.getUrl(), UtopiaMain.getUsername(), UtopiaMain.getPassword());
		
		System.out.println("Please select an option.");
		System.out.println("1) Add/Update/Delete/Read Flights");
		System.out.println("2) Add/Update/Delete/Read Seats");
		System.out.println("3) Add/Update/Delete/Read Tickets and Passengers");
		System.out.println("4) Add/Update/Delete/Read Airports");
		System.out.println("5) Add/Update/Delete/Read Travelers");
		System.out.println("6) Add/Update/Delete/Read Employees");
		System.out.println("7) Over-ride Trip Cancellation for a ticket.");
		System.out.println("8) Close Application");
		
		conn.setAutoCommit(false);
		
		adminMenu(input);
		
		conn.close();
	}
	
	public void adminMenu(Scanner input) throws SQLException, ClassNotFoundException {
		serv = new AdminService();
		int index = validateIntegerInput(input.nextLine(), 1, 8);
		
		switch(index) {
		case 1:
			Statement stmt = conn.createStatement();
			ArrayList<Flight> flights = (ArrayList<Flight>) serv.getAllFlights();
			flightsMenu(input, flights);
			break;
		case 8:
			break;
		default:
			System.out.println("Invalid input. Please try again.");
			adminMenu(input);
			break;
		}
	}
	
	public void flightsMenu(Scanner input, ArrayList<Flight> flights) throws SQLException, ClassNotFoundException {
		System.out.println("Please select an option.");
		System.out.println("1) Add Flights");
		System.out.println("2) Update Flights");
		System.out.println("3) Delete Flights");
		System.out.println("4) Read Flights");
		
		int index = validateIntegerInput(input.nextLine(), 1, 8);
		
		switch(index) {
		case 1:
			
			ArrayList<Route> routes = (ArrayList<Route>) serv.getAllRoutes();
			
			ArrayList<Airplane> planes = (ArrayList<Airplane>) serv.getAllAirplanes();
			
			Flight tflight = new Flight();
			tflight.setId(flights.size()+1);
			
			Route temp = routeMenuLoop(input, routes, 0);
			tflight.setRoute(temp);
			
			Airplane tempa = airplaneMenuLoop(input, planes, 0);
			tflight.setAirplane(tempa);
			
			String dep = departureTime(input);
			tflight.setDeparture_time(Timestamp.valueOf(dep));
			
			int capacity = getCapacity(input, tempa);
			tflight.setReservedSeats(capacity);
			
			tflight.setPrice(149.99f);
			
			serv.addFlight(tflight);
			
			System.out.println(" ");
			System.out.println("Would you like to perform another operation? y/N");
			
			if(input.nextLine().equalsIgnoreCase("y")) {
				flightsMenu(input, flights);
			}
			break;
		case 4:
			for(Flight flight : flights) {
				System.out.println(flight);
			}
			System.out.println(" ");
			System.out.println("Would you like to perform another operation? y/N");
			
			String in = input.nextLine();
			
			if(in.equalsIgnoreCase("y")) {
				flightsMenu(input, flights);
			}
			break;
		default:
			break;
		}
		
	}
	
	public int getCapacity(Scanner input, Airplane plane) {
		System.out.println("Please enter a number of seats to reserve (out of " + plane.getType().getMaxCapacity() + "):");
		try{
			int value = Integer.parseInt(input.nextLine());
			if(value < 0 || value > plane.getType().getMaxCapacity()) {
				System.out.println("Invalid seat number.");
				return getCapacity(input, plane);
			}
			return value;
		}catch(NumberFormatException nfe) {
			System.out.println("Invalid seat number.");
			return getCapacity(input, plane);
		}
	}
	
	public String departureTime(Scanner input) {
		StringBuilder sb = new StringBuilder();
		sb.append(departureYear(input) + "-");
		sb.append(departureMonth(input)+ "-");
		sb.append(departureDay(input)+ " ");
		sb.append(departureHour(input) + ":");
		sb.append(departureMinute(input)+ ":00");
		return sb.toString();
	}
	
	public String departureYear(Scanner input) {
		System.out.println("Please select a departure year to use for this flight.");
		try{
			int value = Integer.parseInt(input.nextLine());
			return Integer.toString(value);
		}catch(NumberFormatException nfe) {
			return departureYear(input);
		}
	}
	
	public String departureMonth(Scanner input) {
		System.out.println("Please select a departure month to use for this flight.");
		try{
			int value = Integer.parseInt(input.nextLine());
			if(value < 1 || value > 12) {
				System.out.println("Invalid month.");
				return departureMonth(input);
			}
			return Integer.toString(value);
		}catch(NumberFormatException nfe) {
			System.out.println("Invalid month.");
			return departureMonth(input);
		}
	}
	
	public String departureDay(Scanner input) {
		System.out.println("Please select a departure day to use for this flight.");
		try{
			int value = Integer.parseInt(input.nextLine());
			if(value < 1 || value > 31) {
				System.out.println("Invalid day.");
				return departureDay(input);
			}
			return Integer.toString(value);
		}catch(NumberFormatException nfe) {
			System.out.println("Invalid day.");
			return departureDay(input);
		}
	}
	
	public String departureHour(Scanner input) {
		System.out.println("Please select a departure hour to use for this flight.");
		try{
			int value = Integer.parseInt(input.nextLine());
			if(value < 0 || value > 23) {
				System.out.println("Invalid hour.");
				return departureHour(input);
			}
			return Integer.toString(value);
		}catch(NumberFormatException nfe) {
			System.out.println("Invalid hour.");
			return departureHour(input);
		}
	}
	
	public String departureMinute(Scanner input) {
		System.out.println("Please select a departure minute to use for this flight.");
		try{
			int value = Integer.parseInt(input.nextLine());
			if(value < 0 || value > 59) {
				System.out.println("Invalid minute.");
				return departureMinute(input);
			}
			return Integer.toString(value);
		}catch(NumberFormatException nfe) {
			System.out.println("Invalid minute.");
			return departureMinute(input);
		}
	}
	
	public Route routeMenuLoop(Scanner input, ArrayList<Route> routes, int offset) throws ClassNotFoundException, SQLException {
		System.out.println("Please select a route to use for this flight.");
		int upperBounds = 7;
		if(routes.size()-offset < 7) {
			upperBounds = routes.size()-offset;
		}
		
		for(int i=0; i<upperBounds; i++) {
			System.out.println((i+1) + ") " + routes.get(i+offset));
		}
		
		if(offset>0) {
			System.out.println("8) Previous");
		}
		if(routes.size()>offset+upperBounds) {
			System.out.println("9) Next");
		}
		System.out.println("0) Quit to Previous Menu");
		
		int index = validateIntegerInput(input.nextLine(), 0, 9);
		
		if(index == -1) {
			System.out.println("Invalid input.");
			return routeMenuLoop(input, routes, offset);
		}else {
			switch(index) {
			case 8:
				if(offset-7 > 0) {
					return routeMenuLoop(input, routes, offset-7);
				}else {
					return routeMenuLoop(input, routes, 0);
				}
			case 9:
				if(offset+7 < routes.size()-7) {
					return routeMenuLoop(input, routes, offset+7);
				}else {
					return routeMenuLoop(input, routes, routes.size()-7);
				}
			case 0:
				return null;
			default:
				if(offset+index-1 < routes.size()) {
					return routes.get(offset+index-1);
				}
				break;
			}
		}
		return null;
	}
	
	public Airplane airplaneMenuLoop(Scanner input, ArrayList<Airplane> planes, int offset) throws ClassNotFoundException, SQLException {
		System.out.println("Please select a route to use for this flight.");
		int upperBounds = 7;
		if(planes.size()-offset < 7) {
			upperBounds = planes.size()-offset;
		}
		
		for(int i=0; i<upperBounds; i++) {
			System.out.println((i+1) + ") " + planes.get(i+offset));
		}
		
		if(offset>0) {
			System.out.println("8) Previous");
		}
		if(planes.size()>offset+upperBounds) {
			System.out.println("9) Next");
		}
		System.out.println("0) Quit to Previous Menu");
		
		int index = validateIntegerInput(input.nextLine(), 0, 9);
		
		if(index == -1) {
			System.out.println("Invalid input.");
			return airplaneMenuLoop(input, planes, offset);
		}else {
			switch(index) {
			case 8:
				if(offset-7 > 0) {
					return airplaneMenuLoop(input, planes, offset-7);
				}else {
					return airplaneMenuLoop(input, planes, 0);
				}
			case 9:
				if(offset+7 < planes.size()-7) {
					return airplaneMenuLoop(input, planes, offset+7);
				}else {
					return airplaneMenuLoop(input, planes, planes.size()-7);
				}
			case 0:
				return null;
			default:
				if(offset+index-1 < planes.size()) {
					return planes.get(offset+index-1);
				}
				break;
			}
		}
		return null;
	}
	
}
