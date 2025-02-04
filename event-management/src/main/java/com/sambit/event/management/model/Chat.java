package com.sambit.event.management.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Chat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	
	@OneToOne
	private Project project;
	
	@JsonIgnore
	@OneToMany(mappedBy = "chat",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Message> messages; 
	
	@ManyToMany
	private List<User> users = new ArrayList<>();

	public Chat() {
		super();
	}

	public Chat(Long id, String name, Project project, List<Message> messages, List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.project = project;
		this.messages = messages;
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Chat [id=" + id + ", name=" + name + ", project=" + project + ", messages=" + messages + ", users="
				+ users + "]";
	}
	
	
}
