package com.movie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class SeatAlreadyBookedException extends RuntimeException{
	private static final long serialVersionUID = 1;
	
	private String SeatName;
	
    private String fieldName;
	
	private Object fieldValue;

	public SeatAlreadyBookedException(String seatName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : %s",seatName,fieldName,fieldValue));
		SeatName = seatName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getSeatName() {
		return SeatName;
	}

	public void setSeatName(String seatName) {
		SeatName = seatName;
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
