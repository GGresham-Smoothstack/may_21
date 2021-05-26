package com.ss.utopia.entity;

import java.sql.Timestamp;

public class Flight {
	
	private int id;
	private Route route;
	private Airplane airplane;
	private Timestamp departure_time;
	private int reservedSeats;
	private float price;
	
	private int year;
	private int day;
	private int month;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Airplane getAirplane() {
		return airplane;
	}
	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}
	public Timestamp getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(Timestamp timestamp) {
		this.departure_time = timestamp;
	}
	public void setTime(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day=day;
	}
	public int getReservedSeats() {
		return reservedSeats;
	}
	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getDeparture_timeString(){
		StringBuilder sb = new StringBuilder();
		sb.append((departure_time.getYear()+1900) + "-" + departure_time.getMonth() + "-" + departure_time.getDay() + " ");
		if(departure_time.getHours() < 10) {
			sb.append("0");
		}
		sb.append(departure_time.getHours());
		sb.append(":");
		if(departure_time.getMinutes() < 10) {
			sb.append("0");
		}
		sb.append(departure_time.getMinutes());
		sb.append(":");
		if(departure_time.getSeconds() < 10) {
			sb.append("0");
		}
		sb.append(departure_time.getSeconds());
		return sb.toString();
	}
	@Override
	public String toString() {
		return route.toString();
		//return route.toString() + " " + airplane.toString() + " " + departure_time.toString() + " " + reservedSeats + " " + price;
	}
	
	public String moreDetails() {
		StringBuilder departTime = new StringBuilder();
		StringBuilder arriveTime = new StringBuilder();
		departTime.append(departure_time.getHours() + ":");
		arriveTime.append((departure_time.getHours()+3) + ":");
		if(departure_time.getMinutes() < 10) {
			departTime.append(0);
			arriveTime.append(0);
		}
		departTime.append(departure_time.getMinutes());
		arriveTime.append(departure_time.getMinutes());
		return "Departure Airport: " + route.getOriginAirport() + " | Arrival Airport: " + route.getDestAirport() +
				" | Departure Date: " + departure_time.getMonth() + "/" + departure_time.getDay() + "/" + (departure_time.getYear()+1900) +
				" | Departure Time: " + departTime.toString() + 
				" | Arrival Date: " + departure_time.getMonth() + "/" + departure_time.getDay() + "/" + (departure_time.getYear()+1900) +
				" | Arrival Time: " + arriveTime.toString();
				
	}
	
	public int[] availableByClass() {
		int[] classSeats = new int[3];
		int maxSeats = airplane.getType().getMaxCapacity();
		classSeats[0] = (int) (maxSeats*0.10);
		classSeats[1] = (int) (maxSeats*0.30);
		classSeats[2] = (int) (maxSeats*0.60);
		/*if(reservedSeats - (maxSeats/10) > 0) {
			classSeats[1] = (maxSeats/30) - (reservedSeats - (maxSeats/10));
		}else {
			classSeats[1] = (maxSeats/30);
		}
		if(reservedSeats - ((maxSeats/10) + (maxSeats/30)) > 0) {
			classSeats[2] = (maxSeats/60) - (reservedSeats - ((maxSeats/10) + (maxSeats/30)));
		}else {
			classSeats[2] = (maxSeats/60);
		}*/
		//classSeats[1] = (maxSeats/30) - (reservedSeats - (maxSeats/10));
		//classSeats[2] = (maxSeats/60) - (reservedSeats - ((maxSeats/10) + (maxSeats/30)));
		
		int reservedSeatsTemp = Integer.valueOf(reservedSeats);
		
		for(int i=0; i<classSeats.length; i++) {
			if(reservedSeatsTemp >= classSeats[i]) {
				reservedSeatsTemp -= classSeats[i];
				classSeats[i] = 0;
				
			}else if(reservedSeatsTemp > 0) {
				classSeats[i] -= reservedSeatsTemp;
				reservedSeatsTemp = 0;
				break;
			}else {
				break;
			}
		}
		
		return classSeats;
	}

}
