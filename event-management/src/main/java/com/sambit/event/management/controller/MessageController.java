package com.sambit.event.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sambit.event.management.model.Chat;
import com.sambit.event.management.model.Message;
import com.sambit.event.management.model.User;
import com.sambit.event.management.request.CreateMessageRequest;
import com.sambit.event.management.service.MessageService;
import com.sambit.event.management.service.ProjectService;
import com.sambit.event.management.service.UserService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/send")
	public ResponseEntity<Message> sendMessage(@RequestBody CreateMessageRequest request) 
			throws Exception{
		User user = userService.findUserById(request.getSenderId());
		if(user==null) throw new Exception("User not found..!");
		Chat chats = projectService.getChatByProjectId(request.getProjectId());
		if(chats==null) throw new Exception("Chats not found..");
		Message sentMessage = messageService.sendMessage(request.getSenderId(), request.getProjectId(), request.getContent());
		return ResponseEntity.ok(sentMessage);
	}
	
	@GetMapping("chat/{projectId}")
	public ResponseEntity<List<Message>> getMessageByChatId(@PathVariable Long projectId)throws Exception{
		List<Message> messages = messageService.getMessageByProjectId(projectId);
		return ResponseEntity.ok(messages);
	}
	
}
