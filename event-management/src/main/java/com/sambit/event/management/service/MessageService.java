package com.sambit.event.management.service;

import java.util.List;

import com.sambit.event.management.model.Message;

public interface MessageService {
	Message sendMessage(Long senderId,Long projectId,String content) throws Exception;
	
	List<Message> getMessageByProjectId(Long projectId) throws Exception;
}
