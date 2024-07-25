package com.sambit.event.management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sambit.event.management.config.JwtProvider;
import com.sambit.event.management.model.User;
import com.sambit.event.management.repository.UserRepository;

@Service
public class UserServiceImplementaion implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findUserProfileByJwt(String jwt) throws Exception {
		String email = JwtProvider.getEmailFromToken(jwt);
		return findUserByEmail(email);
	}

	@Override
	public User findUserByEmail(String email) throws Exception {
		User user = userRepository.findByEmail(email);
		if(user==null)
			throw new Exception("User doesn't exist..!");
		return user;
	}

	@Override
	public User findUserById(Long userId) throws Exception {
		Optional<User> user = userRepository.findById(userId);
		if(user.isEmpty())
			throw new Exception("User doesn't exist..!");
		return user.get();
	}

	@Override
	public User updateUsersProjectSize(User user, int number) {
		user.setProjectSize(user.getProjectSize()+number);
		return userRepository.save(user);
	}

}
