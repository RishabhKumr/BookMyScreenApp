package com.example.demo.dto;

public class TicketBookingDTO {
    private Long userId;
	
	private String userName;
	 
	private String ticketDate;
	
	private String ticketTime;
	
	private String ticketSeat;

	private Long theaterId;
	
	private Long movieId;

	public TicketBookingDTO() {
		super();
	}
	
	public TicketBookingDTO(Long userId, String userName, String ticketDate, String ticketTime, String ticketSeat,
			Long theaterId, Long movieId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.ticketDate = ticketDate;
		this.ticketTime = ticketTime;
		this.ticketSeat = ticketSeat;
		this.theaterId = theaterId;
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

	public String getTicketSeat() {
		return ticketSeat;
	}

	public void setTicketSeat(String ticketSeat) {
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