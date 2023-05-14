package com.movie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class TheaterNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1;
	
	private String theaterName;
	
    private String fieldName;
	
	private Object fieldValue;

	public TheaterNotFoundException(String theaterName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : %s",theaterName,fieldName,fieldValue));
		this.theaterName = theaterName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
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
