package com.sambit.event.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sambit.event.management.model.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {
	
	public List<Issue> findByProjectId(Long projectId);
}
