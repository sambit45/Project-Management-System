package com.sambit.event.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sambit.event.management.model.PlanType;
import com.sambit.event.management.model.Subscription;
import com.sambit.event.management.model.User;
import com.sambit.event.management.service.SubscriptionService;
import com.sambit.event.management.service.UserService;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public ResponseEntity<Subscription> getUserSubscription(@RequestHeader("Authorization") String jwt) throws Exception{
		User user = userService.findUserProfileByJwt(jwt);
		
		Subscription subscription = subscriptionService.getUsersSubscription(user.getId());
		
		return new ResponseEntity<>(subscription,HttpStatus.OK);
	}
	
	@PatchMapping("/upgrade")
	public ResponseEntity<Subscription> upgradeSubscription(@RequestHeader("Authorization") String jwt,
			@RequestParam PlanType planType) throws Exception{
		User user = userService.findUserProfileByJwt(jwt);
		
		Subscription subscription = subscriptionService.upgradSubscription(user.getId(), planType);
		
		return new ResponseEntity<>(subscription,HttpStatus.OK);
	}
	
	
}
