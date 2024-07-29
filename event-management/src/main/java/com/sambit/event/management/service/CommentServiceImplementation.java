package com.sambit.event.management.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.sql.model.internal.OptionalTableUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sambit.event.management.model.Comment;
import com.sambit.event.management.model.Issue;
import com.sambit.event.management.model.User;
import com.sambit.event.management.repository.CommentRepository;
import com.sambit.event.management.repository.IssueRepository;
import com.sambit.event.management.repository.UserRepository;

@Service
public class CommentServiceImplementation implements CommentService{
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private IssueRepository issueRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Comment createComment(Long issueId, Long userId, String content) throws Exception {
		Optional<Issue> optionalIssue = issueRepository.findById(issueId);
		Optional<User> userOptional = userRepository.findById(userId);
		
		if(optionalIssue.isEmpty())
			throw new Exception("Issue Not Found..!");
		if(userOptional.isEmpty())
			throw new Exception("User Not Found..!");
		
		Issue issue = optionalIssue.get();
		User user = userOptional.get();
		
		Comment comment = new Comment();
		comment.setIssue(issue);
		comment.setUser(user);
		comment.setContent(content);
		comment.setCreatedDateTime(LocalDateTime.now());
		
		Comment savedComment = commentRepository.save(comment);
		
		issue.getComments().add(savedComment);
		
		return savedComment;
	}

	@Override
	public void deleteComment(Long commentId, Long userId) throws Exception {
		Optional<Comment> toDeleteComment = commentRepository.findById(commentId);
		Optional<User> userOptional = userRepository.findById(userId);
		
		if(toDeleteComment.isEmpty())
			throw new Exception("Comment not found..!");
		if(userOptional.isEmpty())
			throw new Exception("User not found");
		
		Comment comment = new Comment();
		User user = userOptional.get();
		
		if(comment.getUser().equals(user))
			commentRepository.delete(comment);
		else
			throw new Exception("User does not have permission to delete this comment..!");

	}

	@Override
	public List<Comment> findCommentsByIssueId(Long issueId) {
		return commentRepository.findByIssueId(issueId);
	}

}
