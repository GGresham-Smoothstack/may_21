package com.ss.utopia.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class UtopiaMain extends Menu{
	
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/utopia";
	private static final String username = "root";
	private static final String password = "flpcYxjvvORF6P7wqyBE";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Welcome to the Utopia Airlines Management System. Which category of user are you?");
		System.out.println("1) Employee");
		System.out.println("2) Administrator");
		System.out.println("3) Traveler");
		
		Scanner s = new Scanner(System.in);
		UtopiaMain main = new UtopiaMain();
		EmployeeMenu empMenu = new EmployeeMenu();
		TravellerMenu travMenu = new TravellerMenu();
		AdminMenu admin = new AdminMenu();
		//String input = s.nextLine();
		int menu = main.validateIntegerInput(s.nextLine(), 1, 3);
		
		if(menu!=-1) {
			switch(menu) {
			case 1:
				empMenu.process(s);
				break;
			case 2:
				admin.process(s);
				break;
			case 3:
				travMenu.travellerMenu(s);
				break;
			}
		}else {
			System.out.println("Invalid response.");
		}
	}

	public static String getDriver() {
		return driver;
	}

	public static String getUrl() {
		return url;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}
	
	

}
