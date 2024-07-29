package com.sambit.event.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sambit.event.management.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	List<Comment> findByIssueId(Long issueId);
}
