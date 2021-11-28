package com.engage.service;

import java.util.Properties;
import java.util.Date;
import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Utilities {

    public Utilities() {
    }

    //Generate a new meeting link by calling external API
    public String generateMeetLink(){
		return "https://meet.google.com/uoe-cnxz-tft";
	}
	
    // private void sendmail() throws AddressException, MessagingException, IOException {
	public void sendmail(String onlineClassLink,String studentEmailId,String name,String date,String startTime,String endTime,String course) throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
			  return new PasswordAuthentication("vbvwpbckp@gmail.com", "vbv.ag@wp1");
		   }
		});
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("vbvwpbckp@gmail.com", false));
	 
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(studentEmailId));
		msg.setSubject("Online class scheduled");
		msg.setContent("Content not set", "text/html");
		msg.setSentDate(new Date());
	 
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		String msg_content="Hello "+name+", Your class for course "+course+" is scheduled on "+date+" from "+startTime+" to "+endTime+".The meeting link for the class is "+onlineClassLink ;
		messageBodyPart.setContent(msg_content, "text/html");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		//MimeBodyPart attachPart = new MimeBodyPart();
		//attachPart.attachFile("/var/tmp/image19.png");
		//multipart.addBodyPart(attachPart);
		msg.setContent(multipart);
		Transport.send(msg);   
	}
}
