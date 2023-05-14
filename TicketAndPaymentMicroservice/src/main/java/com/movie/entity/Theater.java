package com.movie.entity;

import java.util.Set;

import jakarta.persistence.Entity;

@Entity
public class Theater {
	
	private Long theaterID;
	
	private String theaterName;
	
	private String theaterAddress;
	
	private Set<String> seats;
	
	private String movie;

	private String location;
	
	private String city;
	
	private String show;

	public Theater() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Theater(Long theaterID, String theaterName, String theaterAddress, Set<String> seats, String movie,
			String location, String city, String show) {
		super();
		this.theaterID = theaterID;
		this.theaterName = theaterName;
		this.theaterAddress = theaterAddress;
		this.seats = seats;
		this.movie = movie;
		this.location = location;
		this.city = city;
		this.show = show;
	}

	public Long getTheaterID() {
		return theaterID;
	}

	public void setTheaterID(Long theaterID) {
		this.theaterID = theaterID;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getTheaterAddress() {
		return theaterAddress;
	}

	public void setTheaterAddress(String theaterAddress) {
		this.theaterAddress = theaterAddress;
	}

	public Set<String> getSeats() {
		return seats;
	}

	public void setSeats(Set<String> seats) {
		this.seats = seats;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}
	
	
}
