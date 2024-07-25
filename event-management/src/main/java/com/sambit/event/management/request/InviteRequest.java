package com.sambit.event.management.request;

public class InviteRequest {
	
	private Long projectId;
	private String email;
	public InviteRequest() {
		super();
	}
	public InviteRequest(Long projectId, String email) {
		super();
		this.projectId = projectId;
		this.email = email;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "InviteRequest [projectId=" + projectId + ", email=" + email + "]";
	}
	
}
