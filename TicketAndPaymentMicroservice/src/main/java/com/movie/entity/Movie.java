package com.movie.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long movieId;
	
	private String movieName;
	
	private String movieGenre;
	
	private String movieCast;
	
	private String movieRating;

	private String movieDuration;
	
	private String movieLink;
	
	private String movieLanguage;
	
	private String movieLogo;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(long movieId, String movieName, String movieGenre, String movieCast, String movieRating,
			String movieDuration, String movieLink, String movieLanguage, String movieLogo) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieCast = movieCast;
		this.movieRating = movieRating;
		this.movieDuration = movieDuration;
		this.movieLink = movieLink;
		this.movieLanguage = movieLanguage;
		this.movieLogo = movieLogo;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieCast() {
		return movieCast;
	}

	public void setMovieCast(String movieCast) {
		this.movieCast = movieCast;
	}

	public String getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
	}

	public String getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getMovieLink() {
		return movieLink;
	}

	public void setMovieLink(String movieLink) {
		this.movieLink = movieLink;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getMovieLogo() {
		return movieLogo;
	}

	public void setMovieLogo(String movieLogo) {
		this.movieLogo = movieLogo;
	}

}
