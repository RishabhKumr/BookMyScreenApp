package com.user.entity;

import java.util.Set;

public class Ticket {
private Long ticketId;
	
	private String ticketDate;
	
	private String ticketTime;
	
	private String ticketStatus;
	
	private Set<String> ticketSeat;

	private Long theaterId;
	
	private Long movieId;
	
	private Long userId;
	
	private String userName;
	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(Long ticketId, String ticketDate, String ticketTime, String ticketStatus, Set<String> ticketSeat,
			Long theaterId, Long movieId, Long userId, String userName) {
		super();
		this.ticketId = ticketId;
		this.ticketDate = ticketDate;
		this.ticketTime = ticketTime;
		this.ticketStatus = ticketStatus;
		this.ticketSeat = ticketSeat;
		this.theaterId = theaterId;
		this.movieId = movieId;
		this.userId = userId;
		this.userName = userName;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
}
