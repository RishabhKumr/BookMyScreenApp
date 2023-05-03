package com.movie.service;

import java.util.List;

import com.movie.entity.Movie;
import com.movie.exceptions.MovieIdAlreadyExistsException;

public interface IMovieService {

public Movie addMovie(Movie movie) throws MovieIdAlreadyExistsException;

public List<Movie> getAllMovies();

public Movie getMovieById(Long movieId);

public List<Movie> getMovieByName(String movieName);

public List<Movie> getMovieByGenre(String movieName);

public String updateMovie(Movie movie);

public boolean deleteMovie(Long movieId);
}