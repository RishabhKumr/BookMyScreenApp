package com.movie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class TicketNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1;
	
	private String ticketName;
    
	private String fieldName;
	
	private Object fieldValue;

	public TicketNotFoundException(String ticketName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : %s",ticketName,fieldName,fieldValue));
		this.ticketName = ticketName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
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
