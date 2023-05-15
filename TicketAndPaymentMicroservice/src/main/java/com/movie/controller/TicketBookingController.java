package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.dto.TicketBookingDTO;
import com.movie.entity.Ticket;
import com.movie.service.TicketBookingServiceImpl;
@RestController
@RequestMapping("/api/v1/ticket")
public class TicketBookingController {

	@Autowired
	private TicketBookingServiceImpl ticketService;
	
	@PostMapping("/bookticket")
	public Ticket bookTicket(@RequestBody TicketBookingDTO ticketDto)
	{
		Ticket ticket = ticketService.bookTicket(ticketDto);
		return ticket;
	}
	
	@GetMapping("/getticketsbyuserid/{userId}")
	public List<Ticket> getTicketsByUserId(@PathVariable Long userId)
	{
		List<Ticket> ticketList = ticketService.getTicketsByUserId(userId);
		return ticketList;
	}
}
