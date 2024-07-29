package com.sambit.event.management.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sambit.event.management.model.Chat;
import com.sambit.event.management.model.Message;
import com.sambit.event.management.model.User;
import com.sambit.event.management.repository.MessageRepository;
import com.sambit.event.management.repository.UserRepository;

@Service
public class MessageServiceImplementation implements MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProjectService projectService;
	
	@Override
	public Message sendMessage(Long senderId, Long projectId, String content) throws Exception {
		User sender = userRepository.findById(senderId).orElseThrow(()-> new Exception("User not found..!"));
		
		Chat chat = projectService.getChatByProjectId(projectId);
		
		Message message = new Message();
		message.setChat(chat);
		message.setContent(content);
		message.setCreatedAt(LocalTime.now());
		message.setSender(sender);
		
		Message savedMessage = messageRepository.save(message);
		
		chat.getMessages().add(savedMessage);
		return savedMessage;
	}

	@Override
	public List<Message> getMessageByProjectId(Long projectId) throws Exception {
		
		Chat chat = projectService.getChatByProjectId(projectId);
		List<Message> findByChatId = messageRepository.findByChatIdOrderByCreatedAtAsc(chat.getId());
		return findByChatId;
	}

}
