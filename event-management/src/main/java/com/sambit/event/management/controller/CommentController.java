package com.sambit.event.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sambit.event.management.model.Comment;
import com.sambit.event.management.model.User;
import com.sambit.event.management.request.CreateCommentRequest;
import com.sambit.event.management.response.MessageResponse;
import com.sambit.event.management.service.CommentService;
import com.sambit.event.management.service.UserService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Comment> createComment(@RequestBody CreateCommentRequest req,
												@RequestHeader("Authorization") String jwt) throws Exception{
		User user = userService.findUserProfileByJwt(jwt);
		Comment createdComment = commentService.createComment(req.getIssueId(), user.getId(), req.getContent());
		return new ResponseEntity<>(createdComment,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{commentId}")
	public ResponseEntity<MessageResponse> deleteComment(@PathVariable Long commentId,
			@RequestHeader("Authorization") String jwt) throws Exception{
				User user = userService.findUserProfileByJwt(jwt);
				commentService.deleteComment(commentId, user.getId());
				MessageResponse response = new MessageResponse();
				response.setMessage("Comment Deleted Successfully..!");
				return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/{issueId}")
	public ResponseEntity<List<Comment>> getCommentByIssueId(@PathVariable Long issueId){
		List<Comment> comments = commentService.findCommentsByIssueId(issueId);
		return new ResponseEntity<>(comments,HttpStatus.OK);
	}
}
