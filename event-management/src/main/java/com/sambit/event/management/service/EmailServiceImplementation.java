package com.sambit.event.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImplementation implements EmailService{
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendEmailWithToken(String userEmail, String link) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
		
		String subject  = "Please Join Project Team Invitation..!";
		
		String text = "Click The Link To Join Project Team.." + link;
		
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(text,true);
		mimeMessageHelper.setTo(userEmail);
		
		try {
			javaMailSender.send(mimeMessage);
		}
		catch (MailSendException e) {
			throw new MailSendException("Failed To Send Email..!");
		}
	}
}
