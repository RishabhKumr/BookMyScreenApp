package com.movie.service;

import com.movie.dto.TicketBookingDTO;
import com.movie.entity.Ticket;

public interface ITicketBookingService {
	
	public Ticket bookTicket(TicketBookingDTO ticketBookingDto);
	
	public String cancelTicket(Long ticketId);
}
