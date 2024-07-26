package com.sambit.event.management.request;

import java.time.LocalDate;

public class IssueRequest {
	
	private String title;
	private String description;
	private String status;
	private Long projectID;
	private String priority;
	private LocalDate dueDate;
	public IssueRequest(String title, String description, String status, Long projectID, String priority,
			LocalDate dueDate) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
		this.projectID = projectID;
		this.priority = priority;
		this.dueDate = dueDate;
	}
	public IssueRequest() {
		super();
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
	@Override
	public String toString() {
		return "IssueRequest [title=" + title + ", description=" + description + ", status=" + status + ", projectID="
				+ projectID + ", priority=" + priority + ", dueDate=" + dueDate + "]";
	}
	
	
}
