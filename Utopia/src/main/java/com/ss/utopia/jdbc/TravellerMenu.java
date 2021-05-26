package com.ss.utopia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.UserDAO;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.User;
import com.ss.utopia.jdbc.Menu;

public class TravellerMenu extends Menu {
	
	private Connection conn;
	
	UserDAO userDAO;
	FlightDAO flightDAO;
	
	PreparedStatement userP;
	
	public void travellerMenu(Scanner input) throws ClassNotFoundException, SQLException {
		
		Class.forName(UtopiaMain.getDriver());
		//2. Connection
		conn = DriverManager.getConnection(UtopiaMain.getUrl(), UtopiaMain.getUsername(), UtopiaMain.getPassword());
		
		userDAO = new UserDAO(conn);
		
		userP = conn.prepareStatement("SELECT * FROM user WHERE username = ?;");
		
		User user = getUser(input);
	}
	
	public User getUser(Scanner input) throws ClassNotFoundException, SQLException {
		System.out.println("Please enter your membership username");
		String id = input.nextLine();
		/*try {
			id = Integer.parseInt(input.nextLine());
		}catch(NumberFormatException nfe) {
			System.out.println("Invalid . Please try again.");
			return getUser(input);
		}*/
		
		userP.setString(1,id);
		List<User> users = userDAO.extractData(userP.executeQuery());
		if(users.size() > 0) {
			return users.get(0);
		}
		System.out.println("Username not found. Please try again.");
		return getUser(input);
		
	}
	
	public void Trav1(Scanner input, User user) throws SQLException, ClassNotFoundException {
		System.out.println("1) Book a Ticket");
		System.out.println("2) Cancel an Upcoming Trip");
		System.out.println("3) Quit to Previous");
		
		int index = validateIntegerInput(input.nextLine(), 1, 3);
		
		switch(index) {
		case 1:
			bookTicket(input, user);
			Trav1(input, user);
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			System.out.println("Invalid input. Please try again.");
			Trav1(input, user);
			break;
		}
	}
	
	public void bookTicket(Scanner input, User user) throws SQLException, ClassNotFoundException {
		flightDAO = new FlightDAO(conn);
		Statement stmt = conn.createStatement();
		String query = "select * from flight";
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Flight> flights = (ArrayList<Flight>)flightDAO.extractData(rs);
		Flight flight = flightMenuLoop(input, flights, 0);
		if(flight!=null) {
			bookMenu(input, user, flight);
		}
	}
	
	public void bookMenu(Scanner input, User user, Flight flight) {
		System.out.println("Pick the Seat you want to book a ticket for.");
		System.out.println("1) View Flight Details");
		System.out.println("2) First");
		System.out.println("3) Business");
		System.out.println("4) Economy");
		System.out.println("5) Quit to cancel operation");
		int index = validateIntegerInput(input.nextLine(), 1, 5);
		switch(index) {
		case 1:
			System.out.println(flight);
			System.out.println(flight.moreDetails());
			bookMenu(input, user, flight);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		default:
			System.out.println("Invalid input. Please try again.");
			bookMenu(input, user, flight);
			break;
		}
	}
	
	public Flight flightMenuLoop(Scanner input, ArrayList<Flight> flights, int offset) throws ClassNotFoundException, SQLException {
		System.out.println("Pick the Flight you want to book a ticket for: ");
		int upperBounds = 7;
		if(flights.size()-offset < 7) {
			upperBounds = flights.size()-offset;
		}
		
		for(int i=0; i<upperBounds; i++) {
			System.out.println((i+1) + ") " + flights.get(i+offset));
		}
		
		if(offset>0) {
			System.out.println("8) Previous");
		}
		if(flights.size()>offset+upperBounds) {
			System.out.println("9) Next");
		}
		System.out.println("0) Quit to Previous Menu");
		
		int index = validateIntegerInput(input.nextLine(), 0, 9);
		
		if(index == -1) {
			System.out.println("Invalid input.");
			return flightMenuLoop(input, flights, offset);
		}else {
			switch(index) {
			case 8:
				if(offset-7 > 0) {
					return flightMenuLoop(input, flights, offset-7);
				}else {
					return flightMenuLoop(input, flights, 0);
				}
			case 9:
				if(offset+7 < flights.size()-7) {
					return flightMenuLoop(input, flights, offset+7);
				}else {
					return flightMenuLoop(input, flights, flights.size()-7);
				}
			case 0:
				return null;
			default:
				if(offset+index-1 < flights.size()) {
					return flights.get(offset+index-1);
				}
				break;
			}
		}
		return null;
	}
	
}