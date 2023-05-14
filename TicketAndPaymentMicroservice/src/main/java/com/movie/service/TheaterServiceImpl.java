package com.movie.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.movie.entity.Theater;
import com.movie.repository.ITheaterRepository;

public class TheaterServiceImpl implements ITheaterService
{
	@Autowired
	private ITheaterRepository theaterRepository;
	
	@Override
	public Theater addTheater(Theater theater) {
		
		return theaterRepository.save(theater);
	}

	@Override
	public Theater updateMovie(String movieId, String theaterId) {
		// TODO Auto-generated method stub
		return null;
	}

}
