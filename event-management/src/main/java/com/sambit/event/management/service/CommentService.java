package com.sambit.event.management.service;

import java.util.List;

import com.sambit.event.management.model.Comment;

public interface CommentService {
	
	
	Comment createComment(Long issueId,Long userId,String comment) throws Exception;
	
	void deleteComment(Long commentId,Long userId) throws Exception;
	
	List<Comment> findCommentsByIssueId(Long issueId);
	
	
	
}
