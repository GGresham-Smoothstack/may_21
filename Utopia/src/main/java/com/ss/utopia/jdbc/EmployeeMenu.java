package com.ss.utopia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import com.ss.utopia.dao.AirportDAO;
import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Flight;



public class EmployeeMenu extends Menu{
	
	private Connection conn;
	FlightDAO flightDAO;
	AirportDAO airportDAO;
	
	public void process(Scanner input) throws ClassNotFoundException, SQLException {
		System.out.println("1) Enter Flights You Manage");
		System.out.println("2) Quit to previous");
		int menu = validateIntegerInput(input.nextLine(), 1, 2);
		if(menu == 1) {
			flightMenu(input);
		}
	}
	
	public void flightMenu(Scanner input) throws ClassNotFoundException, SQLException {
		//System.out.println("");
		//1. Register the driver (MySQL)
				Class.forName(UtopiaMain.getDriver());
				//2. Connection
				conn = DriverManager.getConnection(UtopiaMain.getUrl(), UtopiaMain.getUsername(), UtopiaMain.getPassword());
				//3. Statement
				Statement stmt = conn.createStatement();
				String query = "select * from flight";
				//4. Execution.
				ResultSet rs = stmt.executeQuery(query);
				//while(rs.next()) {
				//	System.out.println("Route ID: "+rs.getInt("id"));
				//	System.out.println("Origin AC: "+rs.getString("origin_id"));
				//	System.out.println("Dest AC: "+rs.getString("destination_id"));
				//}
		
		flightDAO = new FlightDAO(conn);
		
		ArrayList<Flight> flights = (ArrayList<Flight>)flightDAO.extractData(rs);
		
		flightMenuLoop(input, flights, 0);
		
	}
	
	public void flightMenuLoop(Scanner input, ArrayList<Flight> flights, int offset) throws ClassNotFoundException, SQLException {
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
		}else {
			switch(index) {
			case 8:
				if(offset-7 > 0) {
					flightMenuLoop(input, flights, offset-7);
				}else {
					flightMenuLoop(input, flights, 0);
				}
				break;
			case 9:
				if(offset+7 < flights.size()-7) {
					flightMenuLoop(input, flights, offset+7);
				}else {
					flightMenuLoop(input, flights, flights.size()-7);
				}
				break;
			case 0:
				break;
			default:
				if(offset+index-1 < flights.size()) {
					emp3(input, flights.get(offset+index-1));
				}
				break;
			}
		}
		
	}
	
	
	public void emp3(Scanner input, Flight flight) throws ClassNotFoundException, SQLException {
		System.out.println(flight);
		System.out.println("1) View more details about the flight");
		System.out.println("2) Update the details of the Flight");
		System.out.println("3) Add Seats to Flight");
		//TODO: Make option 4 go to submenu 2.
		System.out.println("4) Quit to previous");
		
		int index = validateIntegerInput(input.nextLine(), 1, 4);
		if(index == -1) {
			System.out.println("Invalid input.");
		}else {
			switch(index) {
			case 1:
				emp3Option1(input, flight);
				break;
			case 2:
				emp3Option2(input, flight);
				break;
			}
		}
	}
	
	public void emp3Option1(Scanner input, Flight flight) throws ClassNotFoundException, SQLException {
		System.out.println(flight.moreDetails());
		System.out.println("");
		System.out.println("Available Seats by Class:");
		int[] seatList = flight.availableByClass();
		System.out.println("First → " + seatList[0]);
		System.out.println("Business → " + seatList[1]);
		System.out.println("Economy → " + seatList[2]);
		System.out.println("Press enter key to return.");
		input.nextLine();
		emp3(input, flight);
	}
	
	public void emp3Option2(Scanner input, Flight flight) throws SQLException, ClassNotFoundException {
		System.out.println("Please enter new Origin Airport and City or enter N/A for no change:");
		String originAirport = input.nextLine();
		System.out.println("Please enter new Destination Airport and City or enter N/A for no change:");
		String destAirport = input.nextLine();
		System.out.println("Please enter new Departure Date or enter N/A for no change:");
		String departureDate = input.nextLine();
		System.out.println("Please enter new Departure Time or enter N/A for no change:");
		String departureTime = input.nextLine();
		System.out.println("Please enter new Arrival Date or enter N/A for no change:");
		String arrivalDate = input.nextLine();
		System.out.println("Please enter new Arrival Time or enter N/A for no change:");
		String arrivalTime = input.nextLine();
		
		if(!originAirport.equalsIgnoreCase("N/A")) {
			//originAirport = flight.getRoute().getOriginAirport().getAirportCode();
			PreparedStatement airportPstmt = conn.prepareStatement("SELECT * FROM airport WHERE iata_id = ?" );
			airportPstmt.setString(1, originAirport);
			Airport oAirport = airportDAO.extractData(airportPstmt.executeQuery()).get(0);
			flight.getRoute().setOriginAirport(oAirport);
		}
		
		if(!destAirport.equalsIgnoreCase("N/A")) {
			PreparedStatement airportPstmt = conn.prepareStatement("SELECT * FROM airport WHERE iata_id = ?" );
			airportPstmt.setString(1, destAirport);
			Airport oAirport = airportDAO.extractData(airportPstmt.executeQuery()).get(0);
			flight.getRoute().setDestAirport(oAirport);
		}
		
		LocalDate ld = LocalDate.now();
		
		if(departureDate.equalsIgnoreCase("N/A")) {
			/*StringBuilder sb = new StringBuilder();
			sb.append((flight.getDeparture_time().getMonth()+1900) + "-");
			if(flight.getDeparture_time().getMonth() < 10) {
				sb.append("0");
			}
			sb.append(flight.getDeparture_time().getMonth());
			sb.append("-");
			if(flight.getDeparture_time().getDay() < 10) {
				sb.append("0");
			}
			sb.append(flight.getDeparture_time().getDay());
			departureDate = sb.toString();*/
			
			ld = flight.getDeparture_time().toLocalDateTime().toLocalDate();
			//flight.setDeparture_time(Timestamp.valueOf(null))
		}else{
			ld = LocalDate.parse(departureDate);
		}
		
		if(departureTime.equalsIgnoreCase("N/A")) {
			StringBuilder sb = new StringBuilder();
			if(flight.getDeparture_time().getHours() < 10) {
				sb.append("0");
			}
			sb.append(flight.getDeparture_time().getHours());
			sb.append(":");
			if(flight.getDeparture_time().getMinutes() < 10) {
				sb.append("0");
			}
			sb.append(flight.getDeparture_time().getMinutes());
			sb.append(":");
			if(flight.getDeparture_time().getSeconds() < 10) {
				sb.append("0");
			}
			sb.append(flight.getDeparture_time().getSeconds());
			departureTime = sb.toString();
		}
		
		LocalTime lt = LocalTime.parse(departureTime);
		
		LocalDateTime ldt = LocalDateTime.of(ld, lt);
		
		flight.setDeparture_time(Timestamp.valueOf(ldt));
		
		flightDAO.updateFlight(flight);
		
		System.out.println("Successfully updated.");
		
		//flight.getRoute().setOriginAirport(null);
		
	}
}
