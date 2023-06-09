package com.example.demo.Contoller;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.User;
import com.example.demo.Service.KafkaProducerService;
import com.example.demo.Service.UserService;
import com.example.demo.dto.Movie;
import com.example.demo.dto.ResponseHandler;
import com.example.demo.dto.Ticket;
import com.example.demo.dto.TicketBookingDTO;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*",allowedHeaders="*")
public class UserController {
	@Autowired
	public RestTemplate restTemplate;
	@Autowired
	private UserService uService;
	
	@Autowired
	KafkaProducerService kafka;
	

	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUsers() {
		List<User> userlist = uService.getAllUsers();

		if (userlist != null) {
			return new ResponseEntity<List<User>>(userlist, HttpStatus.OK);
		}
		return new ResponseEntity<String>("userlist is empty", HttpStatus.NO_CONTENT);
	}

	@GetMapping("/allmovies")
	public ResponseEntity<?> getAllMovies() {
		String url = "http://localhost:8084/api/v1/movie/getAllMovies";
		List<Movie> movieList = this.restTemplate.getForObject(url, List.class);
		if (movieList != null) {
			CacheControl cacheControl = CacheControl.maxAge(30, TimeUnit.MINUTES);
			return ResponseEntity.ok().cacheControl(cacheControl)
					.body(ResponseHandler.generateResponse("Successfully fetched Movies", HttpStatus.OK, movieList));
		}
		return new ResponseEntity<String>("Movie List is Empty!", HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/bookticket")
	public ResponseEntity<?> bookAllMovies(@RequestBody TicketBookingDTO ticketBookingDto){
		String url="http://localhost:8085/api/v1/ticket/bookticket"; 
		HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity entity = new HttpEntity(ticketBookingDto,headers);
			ResponseEntity<?> status = this.restTemplate.exchange(url, HttpMethod.POST,entity, Ticket.class);
			return status;
	}
	
	@Async
	@PostMapping("/addmovie")
	public ResponseEntity<?> addMovie(@RequestBody Movie movie)
	{
		String url = "http://localhost:8084/api/v1/movie/addMovie";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(movie,headers);
		ResponseEntity<?> status = this.restTemplate.exchange(url, HttpMethod.POST,entity, Movie.class);
     	//kafka.setTemp(status.toString());
		return status;
	}
	
	@GetMapping("/searchbyname/{movieName}")
	public ResponseEntity<?> searchMovieByName(@PathVariable String movieName)
	{
		String url = "http://localhost:8084/api/v1/movie/getMovieByGenre/"+movieName;
		List<Movie> movieList = this.restTemplate.getForObject(url, List.class);
	    if(movieList != null) {
	        CacheControl cacheControl = CacheControl.maxAge(30,TimeUnit.MINUTES);
	        return ResponseEntity.ok().cacheControl(cacheControl)
	                .body(ResponseHandler.generateResponse("Successfully fetched Movies", HttpStatus.OK, movieList));
	    }
	    return new ResponseEntity<String>("Movie Not Found!",HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/searchbygenre/{genre}")
	public ResponseEntity<?> searchMovieByGenre(@PathVariable String genre){
		String url = "http://localhost:8084/api/v1/movie/getMovieByGenre/"+genre;
		List<Movie> movieList = this.restTemplate.getForObject(url, List.class);
	    if(movieList != null) {
	        CacheControl cacheControl = CacheControl.maxAge(30,TimeUnit.MINUTES);
	        return ResponseEntity.ok().cacheControl(cacheControl)
	                .body(ResponseHandler.generateResponse("Successfully fetched Movies", HttpStatus.OK, movieList));
	    }
	    return new ResponseEntity<String>("Movies Not Found!",HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/searchbyid/{id}")
	public ResponseEntity<?> searchByMovieId(@PathVariable Long id){
		String url = "http://localhost:8084/api/v1/movie/getMovieById/"+id;
		Movie movie = this.restTemplate.getForObject(url, Movie.class);
	    if(movie != null) {
	        CacheControl cacheControl = CacheControl.maxAge(30,TimeUnit.MINUTES);
	        return ResponseEntity.ok().cacheControl(cacheControl)
	                .body(ResponseHandler.generateResponse("Successfully fetched Movies", HttpStatus.OK, movie));
	    }
	    return new ResponseEntity<String>("Movie Not Found!",HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/ticketbyuserid/{id}")
	public ResponseEntity<?> getTicketByUserId(@PathVariable Long id)
	{
		String url = "http://localhost:8085/api/v1/ticket/getticketsbyuserid/"+id;
		List<Ticket> ticket = this.restTemplate.getForObject(url, List.class);
		 if(ticket != null) {
		        CacheControl cacheControl = CacheControl.maxAge(30,TimeUnit.MINUTES);
		        return ResponseEntity.ok().cacheControl(cacheControl)
		                .body(ResponseHandler.generateResponse("Successfully fetched Ticket", HttpStatus.OK, ticket));
		    }
		    return new ResponseEntity<String>("Ticket Not Found!",HttpStatus.NO_CONTENT);
	}
}