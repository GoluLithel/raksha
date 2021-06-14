package com.raksha.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.raksha.entity.OTPResponse;
import com.sun.mail.smtp.SMTPAddressFailedException;

public class Mail {
	
	// Sender's email ID needs to be mentioned
	private final static String SENDER = "raksha.vehicle.insurance@gmail.com";
	
	// Sender's password of email ID
	private final static String PASSWORD = "Raksha@123";
	
	// Limiting OTP to 4 digit only
	private final static int OTP_LIMIT = 9999;
	
	
	// Setting properties for session
	private static Properties setProperties() {
		Properties properties = System.getProperties();
		
		// setting Gmail host
		final String host = "smtp.gmail.com";
		
		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		return properties;
	}
	
	//Setting Session to for sender
	private static Session setSession() {
		return  Session.getInstance(setProperties(), new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(SENDER,PASSWORD);
			}
		});
	}
	
	private static String GenerateOTP() {
		
		int OTP = (int) (Math.random() * OTP_LIMIT);
		
		String OTPstr = String.format("%4s", OTP).replace(' ', '0');
		
		return OTPstr;
	}

	public static OTPResponse sendOTP(String sendTo) {
		
		// Get the Session object.		
		Session session= setSession();
		
		// Genrate OTP
		String OTP = GenerateOTP();
		
		// Sending OTP Response Object
		OTPResponse otpResponse = new OTPResponse();

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(SENDER));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));

			// Set Subject: header field
			message.setSubject("OTP: Do Not Replay");

			// Now set the actual message
			message.setText("One Time Password:\n\n\n\t\t"+OTP);

			// Send message
			Transport.send(message);
			System.out.println("OTP IS SENT");
			
			otpResponse.setOTP(OTP);
			otpResponse.setStatus("OTP IS SENT");
			
		} catch (SMTPAddressFailedException e) {
			System.out.println(e.toString());
			System.out.println("INVALID MAIL ADDRESS");
			
			otpResponse.setOTP(OTP);
			otpResponse.setStatus("INVALID MAIL ADDRESS");
			
		} catch (MessagingException mex) {
			mex.printStackTrace();
			System.out.println(mex.toString());
			System.out.println("OTP IS NOT SENT");
			
			otpResponse.setOTP(OTP);
			otpResponse.setStatus("OTP IS NOT SENT");
		}
		
		
		return otpResponse;
	}

}
