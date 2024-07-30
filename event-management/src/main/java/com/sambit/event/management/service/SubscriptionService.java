package com.sambit.event.management.service;

import com.sambit.event.management.model.PlanType;
import com.sambit.event.management.model.Subscription;
import com.sambit.event.management.model.User;

public interface SubscriptionService {
	Subscription createSubscription(User user);
	Subscription getUsersSubscription(Long userId) throws Exception;
	Subscription upgradSubscription(Long userId,PlanType planType);
	boolean isValid(Subscription subscription);
}
