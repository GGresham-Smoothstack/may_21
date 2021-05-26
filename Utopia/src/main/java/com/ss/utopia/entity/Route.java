package com.ss.utopia.entity;

public class Route {

	private Integer id;
	private Airport originAirport;
	private Airport destAirport;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Airport getOriginAirport() {
		return originAirport;
	}
	public void setOriginAirport(Airport originAriport) {
		this.originAirport = originAriport;
	}
	public Airport getDestAirport() {
		return destAirport;
	}
	public void setDestAirport(Airport destAirport) {
		this.destAirport = destAirport;
	}
	
	@Override
	public String toString() {
		
		return originAirport + " → " + 
				destAirport.getAirportCode();
		
	}
}