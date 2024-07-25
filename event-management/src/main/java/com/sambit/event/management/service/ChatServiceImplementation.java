package com.sambit.event.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sambit.event.management.model.Chat;
import com.sambit.event.management.repository.ChatRepository;

@Service
public class ChatServiceImplementation implements ChatService {
	
	@Autowired
	private ChatRepository chatRepository;
	
	@Override
	public Chat createChat(Chat chat) {
		return chatRepository.save(chat);
	}

}
