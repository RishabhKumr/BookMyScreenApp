package com.movie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1;
	
	private String movieName;
	
	private String fieldName;
	
	private Object fieldValue;

	public MovieNotFoundException(String movieName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : %s",movieName,fieldName,fieldValue));
		this.movieName = movieName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
