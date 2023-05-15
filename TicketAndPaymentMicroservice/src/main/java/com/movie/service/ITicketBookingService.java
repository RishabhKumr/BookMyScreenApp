package com.movie.service;

import java.util.List;

import com.movie.dto.TicketBookingDTO;
import com.movie.entity.Ticket;

public interface ITicketBookingService {
	
	public Ticket bookTicket(TicketBookingDTO ticketBookingDto);
	
	public String cancelTicket(Long ticketId);
	
	public List<Ticket> getTicketsByUserId(Long userId);
}
