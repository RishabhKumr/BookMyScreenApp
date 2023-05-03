package com.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entity.Movie;
import com.movie.exceptions.MovieIdAlreadyExistsException;
import com.movie.repository.MovieRepository;

@Service
public class MovieServiceImpl implements IMovieService{

@Autowired
private MovieRepository movieRepository;

@Override
public Movie addMovie(Movie movie) throws MovieIdAlreadyExistsException {
    Optional<Movie> movieObj = movieRepository.findById(movie.getMovieId());
    if(movieObj.isPresent()) {
        throw new MovieIdAlreadyExistsException();
    }
    else
    {
        return movieRepository.saveAndFlush(movie);
    }
}

@Override
public List<Movie> getAllMovies() {
    return movieRepository.findAll();
}

@Override
public Movie getMovieById(Long movieId) {
    return movieRepository.findById(movieId).get();
}

@Override
public List<Movie> getMovieByName(String movieName) {
    return movieRepository.findByMovieName(movieName);
}

@Override
public boolean deleteMovie(Long movieId) {
    movieRepository.deleteById(movieId);
    return true;
}

@Override
public List<Movie> getMovieByGenre(String movieName) {
	return movieRepository.findByMovieGenre(movieName);
}

@Override
public String updateMovie(Movie movie) {
	String status = "Not Updated! Check Logs";
	Movie movieObj = movieRepository.findById(movie.getMovieId()).orElseThrow(
			() -> new com.movie.exceptions.MovieNotFoundException("Movie", "Id", movie.getMovieId()));
	if(movieObj != null) {
		movieObj.setMovieName(movie.getMovieName());
		movieObj.setMovieCast(movie.getMovieCast());
		movieObj.setMovieDuration(movie.getMovieDuration());
		movieObj.setMovieGenre(movie.getMovieGenre());
		movieObj.setMovieLanguage(movie.getMovieLanguage());
		movieObj.setMovieLink(movie.getMovieLink());
		movieObj.setMovieLogo(movie.getMovieLogo());
		movieObj.setMovieRating(movie.getMovieRating());
		movieRepository.save(movieObj);
		status="Updated!";
	}
	return status;
}
}