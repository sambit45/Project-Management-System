package com.sambit.event.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sambit.event.management.model.Invitation;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {
	
	Invitation findByToken(String token);
	
	Invitation findByEmail(String userEmail);
	
}
