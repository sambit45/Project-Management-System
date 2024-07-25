package com.sambit.event.management.service;

import com.sambit.event.management.model.Invitation;

import jakarta.mail.MessagingException;

public interface InvitationService {
	public void sendsInvitation(String email,Long projectId) throws MessagingException;
	
	public Invitation acceptInvitation(String token,Long userId) throws Exception;
	
	public String getTokenByUserMail(String userEmail);
	
	public void deleteToken(String token);
}
