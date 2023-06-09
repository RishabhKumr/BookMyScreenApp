package com.movie.controller;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.customresponse.ResponseHandler;
import com.movie.entity.Movie;
import com.movie.exceptions.MovieIdAlreadyExistsException;
import com.movie.exceptions.MovieNotFoundException;
import com.movie.service.MovieServiceImpl;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

@Autowired
private MovieServiceImpl movieService;
Logger logger = LoggerFactory.getLogger(MovieController.class);

@PostMapping("/addMovie")
public ResponseEntity<?> addMovie(@RequestBody Movie movie) throws MovieIdAlreadyExistsException{
    
    if(movieService.addMovie(movie) != null) {
        return new ResponseEntity<Movie>(movie,HttpStatus.CREATED);
    }
    logger.info("API CALL:   /addMovie");
    return new ResponseEntity<String>("Movie is not created in DB",HttpStatus.CONFLICT);
}

@GetMapping("/getAllMovies")
public List<Movie> getAllMovies(){
	logger.info("API CALL:   /getAllMovies");
    return movieService.getAllMovies();
}

@GetMapping("/getMovieByName/{movieName}")
public ResponseEntity<?> getMovieByName(@PathVariable String movieName) throws MovieNotFoundException
{
    List<Movie> movieList = movieService.getMovieByName(movieName);
    if(!movieList.isEmpty()) {
        return new ResponseEntity<List>( movieList, HttpStatus.OK);
    }
    logger.info("API CALL:   /getMovieByName");
    return new ResponseEntity<String>("Movie Not Found!",HttpStatus.NO_CONTENT);
}

@GetMapping("/getMovieById/{movieId}")
public ResponseEntity<?> getMovieById(@PathVariable Long movieId) throws MovieNotFoundException
{
    Movie movie = movieService.getMovieById(movieId);
    if(movie != null) {
        return new ResponseEntity<Movie>( movie, HttpStatus.OK);
    }
    return new ResponseEntity<String>("Movie Not Found!",HttpStatus.NO_CONTENT);
} 
@DeleteMapping("/deletemovie/{movieId}")
public ResponseEntity<?> deleteMovie(@PathVariable Long movieId)
{
	movieService.deleteMovie(movieId);
	return new ResponseEntity<String>("Movie Deleted!",HttpStatus.OK);
}
@GetMapping("/getMovieByGenre/{movieName}")
public ResponseEntity<?> getMovieByGenre(@PathVariable String movieName) throws MovieNotFoundException
{
    List<Movie> movieList = movieService.getMovieByGenre(movieName);
    if(!movieList.isEmpty()) {
        return new ResponseEntity<List>( movieList, HttpStatus.OK);
    }
    return new ResponseEntity<String>("Movie Not Found!",HttpStatus.NO_CONTENT);
}
@PutMapping("/updatemovie")
public ResponseEntity<?> updateMovies(@RequestBody Movie movie){
	String message = movieService.updateMovie(movie);
	return new ResponseEntity<String>( message, HttpStatus.OK);
}
}