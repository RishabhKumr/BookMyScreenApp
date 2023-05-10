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
	
	@JsonBackReference
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="theaterId")
	private Theater theater;
	
	@JsonBackReference
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="movieId")
	private Movie movie;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
}
	