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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String description;
	private String category;
	
	private List<String> tags = new ArrayList<>();
	
	@JsonIgnore
	@OneToOne(mappedBy = "project",cascade = CascadeType.ALL,orphanRemoval = true)
	private Chat chat;
	
	@ManyToOne
	private User owner;
	
	@OneToMany(mappedBy = "project",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Issue> issue = new ArrayList<>();
	
	@ManyToMany
	private List<User> team = new ArrayList<>();

	public Project() {
		super();
	}

	public Project(Long id, String name, String description, String category, List<String> tags, Chat chat, User owner,
			List<Issue> issue, List<User> team) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.tags = tags;
		this.chat = chat;
		this.owner = owner;
		this.issue = issue;
		this.team = team;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<Issue> getIssue() {
		return issue;
	}

	public void setIssue(List<Issue> issue) {
		this.issue = issue;
	}

	public List<User> getTeam() {
		return team;
	}

	public void setTeam(List<User> team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category
				+ ", tags=" + tags + ", chat=" + chat + ", owner=" + owner + ", issue=" + issue + ", team=" + team
				+ "]";
	}
	
	

	
}
