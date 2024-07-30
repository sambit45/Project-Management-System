package com.sambit.event.management.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.sambit.event.management.model.PlanType;
import com.sambit.event.management.model.Subscription;
import com.sambit.event.management.model.User;
import com.sambit.event.management.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImplementation implements SubscriptionService{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Override
	public Subscription createSubscription(User user) {
		Subscription subscription = new Subscription();
		subscription.setUser(user);
		subscription.setPlanType(PlanType.FREE);
		subscription.setSubStartDate(LocalDate.now());
		subscription.setSubEndDate(LocalDate.now().plusMonths(12));
		subscription.setValid(true);
		
		subscriptionRepository.save(subscription);
		
		return subscription;
	}

	@Override
	public Subscription getUsersSubscription(Long userId) throws Exception {
		 Subscription subscription = subscriptionRepository.findByUserId(userId);
		 if(!isValid(subscription)) {
			 subscription.setPlanType(PlanType.FREE);
			 subscription.setSubStartDate(LocalDate.now());
			 subscription.setSubEndDate(LocalDate.now().plusYears(1));
		 }
		 return subscriptionRepository.save(subscription);
	}

	@Override
	public Subscription upgradSubscription(Long userId, PlanType planType) {
		Subscription subscription = subscriptionRepository.findByUserId(userId);
		
		subscription.setPlanType(planType);
		subscription.setSubStartDate(LocalDate.now());
		if(planType.equals(PlanType.ANNUALLY))
			subscription.setSubEndDate(LocalDate.now().plusYears(1));
		else
			subscription.setSubEndDate(LocalDate.now().plusMonths(1));
		
		
		return subscriptionRepository.save(subscription);
	}

	@Override
	public boolean isValid(Subscription subscription) {
		if(subscription.getPlanType().equals(PlanType.FREE))
			return true;
		LocalDate currentDate = LocalDate.now();
		LocalDate endDate = subscription.getSubEndDate();
		
		return endDate.isAfter(currentDate) || endDate.equals(currentDate);
	}

}
