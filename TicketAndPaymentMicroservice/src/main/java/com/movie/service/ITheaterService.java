package com.movie.service;

import com.movie.entity.Theater;

public interface ITheaterService {
	public Theater addTheater(Theater theater);
	public Theater updateMovie(String movieId,String theaterId);
}
