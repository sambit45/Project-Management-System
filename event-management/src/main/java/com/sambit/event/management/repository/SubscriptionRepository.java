package com.sambit.event.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sambit.event.management.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
	
	Subscription findByUserId(Long userId);
	
	
}
