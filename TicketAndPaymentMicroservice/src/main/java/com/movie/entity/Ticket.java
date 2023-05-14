package com.movie.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ticketId;
	
	private String ticketDate;
	
	private String ticketTime;
	
	private String ticketStatus;
	
	private Set<String> ticketSeat;

	private Long theaterId;
	
	private Long movieId;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(Long ticketId, String ticketDate, String ticketTime, String ticketStatus, Set<String> ticketSeat,
			Long theaterId, Long movieId) {
		super();
		this.ticketId = ticketId;
		this.ticketDate = ticketDate;
		this.ticketTime = ticketTime;
		this.ticketStatus = ticketStatus;
		this.ticketSeat = ticketSeat;
		this.theaterId = theaterId;
		this.movieId = movieId;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(String ticketDate) {
		this.ticketDate = ticketDate;
	}

	public String getTicketTime() {
		return ticketTime;
	}

	public void setTicketTime(String ticketTime) {
		this.ticketTime = ticketTime;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public Set<String> getTicketSeat() {
		return ticketSeat;
	}

	public void setTicketSeat(Set<String> ticketSeat) {
		this.ticketSeat = ticketSeat;
	}

	public Long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(Long theaterId) {
		this.theaterId = theaterId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	
	
}
	