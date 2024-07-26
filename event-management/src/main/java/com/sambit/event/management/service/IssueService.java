package com.sambit.event.management.service;

import java.util.List;
import java.util.Optional;

import com.sambit.event.management.model.Issue;
import com.sambit.event.management.model.User;
import com.sambit.event.management.request.IssueRequest;

public interface IssueService {
	
	Issue getIssueById(Long issueId) throws Exception;
	
	List<Issue> getIssueByProjectId(Long projectId) throws Exception;
	
	Issue createIssue(IssueRequest issue,User user) throws Exception;
		
	void deleteIssue(Long issueId,Long userId) throws Exception;
	
	Issue addUserToIssue(Long issueId,Long userId) throws Exception;
	
	Issue updateStatus(Long issueId,String status) throws Exception;
	
}
