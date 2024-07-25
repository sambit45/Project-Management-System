package com.sambit.event.management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Invitation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String token;
	private String email;
	private Long projectId;
	public Invitation() {
		super();
	}
	public Invitation(Long id, String token, String email, Long projectId) {
		super();
		this.id = id;
		this.token = token;
		this.email = email;
		this.projectId = projectId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	@Override
	public String toString() {
		return "Invitation [id=" + id + ", token=" + token + ", email=" + email + ", projectId=" + projectId + "]";
	}
	
	
	
}
