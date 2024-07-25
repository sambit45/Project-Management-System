package com.sambit.event.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sambit.event.management.model.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {
	
}
