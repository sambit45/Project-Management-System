package com.sambit.event.management.model;

import java.time.LocalDate;
import java.util.List;

public class IssueDTO {
	
	private Long id;
	private String title;
	private String description;
	private String status;
	private Long projectID;
	private String priority;
	private LocalDate dueDate;
	private List<String> tags;
	
	private User assignee;
	private Project project;
	public IssueDTO() {
		super();
	}
	public IssueDTO(Long id, String title, String description, String status, Long projectID, String priority,
			LocalDate dueDate, List<String> tags, User assignee, Project project) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.projectID = projectID;
		this.priority = priority;
		this.dueDate = dueDate;
		this.tags = tags;
		this.assignee = assignee;
		this.project = project;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getProjectID() {
		return projectID;
	}
	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public User getAssignee() {
		return assignee;
	}
	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "IssueDTO [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", projectID=" + projectID + ", priority=" + priority + ", dueDate=" + dueDate + ", tags=" + tags
				+ ", assignee=" + assignee + ", project=" + project + "]";
	}

	
}
