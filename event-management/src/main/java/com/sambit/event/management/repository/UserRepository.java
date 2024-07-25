package com.sambit.event.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sambit.event.management.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	User findByEmail(String email);
}
