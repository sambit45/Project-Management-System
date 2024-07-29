package com.sambit.event.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sambit.event.management.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

	List<Message> findByChatIdOrderByCreatedAtAsc(Long id);

}
