package com.movie.entity;

public class Payment {
	private Long paymentId;
	
	private Long transactionId;
	
	private Long ticketId;
	
	private String status;
	
	private String paymentMethod;
	
	private String time;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Long paymentId, Long transactionId, Long ticketId, String status, String paymentMethod,
			String time) {
		super();
		this.paymentId = paymentId;
		this.transactionId = transactionId;
		this.ticketId = ticketId;
		this.status = status;
		this.paymentMethod = paymentMethod;
		this.time = time;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
