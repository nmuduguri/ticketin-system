package com.railways.service;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.railways.UserDetailsCache;
import com.railways.utils.StoreOTP;

@Service
public class EmailService {

	@Autowired
	private UserDetailsCache userDetailsCache;

	@Value("${spring.mail.username}")
	private String fromMail;

	@Value("${spring.mail.password}")
	private String password;

	@Value("${spring.mail.host}")
	private String host;

	@Value("${spring.mail.properties.protocol}")
	private String protocol;

	@Value("${spring.mail.port}")
	private String port;

	@Value("${spring.mail.properties.auth}")
	private boolean auth;

	@Value("${spring.mail.properties.sslenable}")
	private boolean sslEnable;

	@Value("${spring.mail.properties.sslrequired}")
	private boolean sslRequired;

	@Value("${spring.mail.properties.debug}")
	private boolean debug;

	public void sendOtpMessage(String email) throws MessagingException {

		Properties properties = System.getProperties();

		// Setup email server Configuration
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.transport.protocol", protocol);
		properties.put("mail.smtp.auth", auth);
		properties.put("mail.smtp.ssl.enable", sslEnable);
		properties.put("mail.smtp.ssl.required", sslRequired);
		properties.put("mail.debug", debug);

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromMail, password);
			}

		});
		session.setDebug(true);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromMail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("New OTP, Generated By Ticket Booking System");

			Integer min = 100000;
			Integer max = 999999;

			Integer otp = (int) Math.floor(Math.random() * (max - min + 1) + min);
			
			Long startSeconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
			StoreOTP storeOTP = new StoreOTP(otp.toString(),startSeconds);
			userDetailsCache.setOTP(email, storeOTP);
			
			
			message.setText("Dear User, \n\nYour New OTP Code Is: " + otp
					+ ", And It will valid for 2-Minuits, Never Share with Any One.\n\nThanks & Regards,\nTicketing System Team");
			Transport.send(message);
			System.out.println("Sent message successfully....");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

	}
}
