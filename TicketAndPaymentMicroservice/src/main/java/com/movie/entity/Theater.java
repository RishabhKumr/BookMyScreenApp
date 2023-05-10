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

	public Theater() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Theater(Long theaterID, String theaterName, String theaterAddress, Set<String> seats, String movie) {
		super();
		this.theaterID = theaterID;
		this.theaterName = theaterName;
		this.theaterAddress = theaterAddress;
		this.seats = seats;
		this.movie = movie;
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
	
	
}
