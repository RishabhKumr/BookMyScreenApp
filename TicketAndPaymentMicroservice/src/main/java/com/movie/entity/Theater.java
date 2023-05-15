package com.movie.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Theater {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long theaterID;
	
	private String theaterName;
	
	private Set<String> seats;
	
	private String movie;
	
	private String city;
	

	public Theater() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Theater(Long theaterID, String theaterName, Set<String> seats, String movie, String city) {
		super();
		this.theaterID = theaterID;
		this.theaterName = theaterName;
		this.seats = seats;
		this.movie = movie;
		this.city = city;
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


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

}
