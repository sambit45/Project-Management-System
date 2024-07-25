package com.sambit.event.management.response;


public class AuthResponse {
	private String message;
	private String jwt;
	
	
	public AuthResponse() {
		super();
	}
	
	public AuthResponse(String message, String jwt) {
		super();
		this.message = message;
		this.jwt = jwt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	@Override
	public String toString() {
		return "AuthResponse [message=" + message + ", jwt=" + jwt + "]";
	}
	
	
}
