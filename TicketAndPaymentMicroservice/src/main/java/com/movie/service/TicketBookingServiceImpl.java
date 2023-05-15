package com.movie.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.dto.TicketBookingDTO;
import com.movie.entity.Movie;
import com.movie.entity.Theater;
import com.movie.entity.Ticket;
import com.movie.repository.ITheaterRepository;
import com.movie.repository.ITicketRepository;

@Service
public class TicketBookingServiceImpl implements ITicketBookingService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ITicketRepository ticketRepository;
	
	@Autowired
	private ITheaterRepository theaterRepository;
	
	public String url = "http://localhost:8084/api/v1/movie/";

	@Override
	public Ticket bookTicket(TicketBookingDTO ticketBookingDto) {
		
		String serviceUrl = url+"getMovieById"+"/"+ticketBookingDto.getMovieId();
		Movie movie = this.restTemplate.getForObject(serviceUrl, Movie.class);
		
		Optional<Theater> theater = theaterRepository.findById(ticketBookingDto.getTheaterId());
		
		Ticket ticket = new Ticket();
		
			Set<String> seats = new HashSet<>();
			seats.add(ticketBookingDto.getTicketSeat());
			ticket.setMovieId(movie.getMovieId());
			ticket.setTheaterId(theater.get().getTheaterID());
			ticket.setTicketDate(ticketBookingDto.getTicketDate());
			ticket.setTicketSeat(seats);
			ticket.setTicketStatus("Booked");
			ticket.setTicketTime(ticketBookingDto.getTicketTime());
			ticket.setUserId(ticketBookingDto.getUserId());
			ticketRepository.save(ticket);
		
		
		return ticket;
		
	}

	@Override
	public String cancelTicket(Long ticketId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getTicketsByUserId(Long userId) {
		List<Ticket> ticketList = ticketRepository.findByUserId(userId);
		return ticketList;
	}

}
