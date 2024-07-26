package com.sambit.event.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sambit.event.management.model.Issue;
import com.sambit.event.management.model.Project;
import com.sambit.event.management.model.User;
import com.sambit.event.management.repository.IssueRepository;
import com.sambit.event.management.request.IssueRequest;

@Service
public class IssueServiceImplementation implements IssueService{
	
	@Autowired
	private IssueRepository issueRepository;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Issue getIssueById(Long issueId) throws Exception {
		Optional<Issue> issue = issueRepository.findById(issueId);
		if(issue.isPresent())
			return issue.get();
		throw new Exception("No issue found with issueid" + issueId);
	}

	@Override
	public List<Issue> getIssueByProjectId(Long projectId) throws Exception {
		return issueRepository.findByProjectId(projectId);
	}

	@Override
	public Issue createIssue(IssueRequest issueRequest, User user) throws Exception {
		Project project = projectService.getProjectById(issueRequest.getProjectID());
		
		Issue issue = new Issue();
		issue.setTitle(issueRequest.getTitle());
		issue.setDescription(issueRequest.getDescription());
		issue.setStatus(issueRequest.getStatus());
		issue.setDueDate(issueRequest.getDueDate());
		issue.setPriority(issueRequest.getPriority());
		issue.setProjectID(issueRequest.getProjectID());
		
		issue.setProject(project);
		
		return issueRepository.save(issue);
	}

	@Override
	public void deleteIssue(Long issueId, Long userId) throws Exception {
		getIssueById(issueId);
		issueRepository.deleteById(issueId);
		
	}

	@Override
	public Issue addUserToIssue(Long issueId, Long userId) throws Exception {
		User user = userService.findUserById(userId);
		Issue issue = getIssueById(issueId);
		issue.setAssignee(user);
		return issueRepository.save(issue);
	}

	@Override
	public Issue updateStatus(Long issueId, String status) throws Exception {
		Issue issue = getIssueById(issueId);
		issue.setStatus(status);
		return issueRepository.save(issue);
	}

}
