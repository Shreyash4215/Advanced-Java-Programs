// smtp = Simple Mail Transfer Protocol

import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.*;

class GmailwthAtachmentDemo
{
	public static void main(String args[])
	{
		//Information Sender,Receiver,Mail Subject And Mail Msg
		
		String from = "Your email";
		String to = "Reciepent email";
		String sub = "Testing Mail";
		String msg = "Hello Receiver I m Shreyash This MSg is Send Through Java Code";
		
		Properties prop = new Properties();
		
		// Some Important Setting for Sending mail
		prop.put("mail.smtp.ssl.enable", "true");		//ssl = Secure Sockets Layer 
		prop.put("mail.smtp.auth", "true");				//email & Password Authunticaton prop unabled 
		prop.put("mail.smtp.host", "smtp.gmail.com");	//Declrtion of site from which you want send mail
		prop.put("mail.smtp.port", "465");				//465 is port of gmail
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		//Email & Password Authentication Process To check your information Correct Or Not
		
		Session session = Session.getInstance(prop,
		  new javax.mail.Authenticator()
		  {
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(from, "Your Email pass"); //email and pass of sender
			}
		  });  
		try 
		{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));		//from = Sender email adress Declared At Top
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));					//to = reciever email adress Declared At Top
			message.setSubject(sub);						//sub = email Subject Declared At Top

			String path = "F:\\Java Progs\\Image\\exit.png";//path of file to attach

					 
			MimeBodyPart textmine = new MimeBodyPart();  	//Object created for Body Message        
			MimeBodyPart filemine = new MimeBodyPart();  	//Object created for File Attachment
		  
			//process to attaching file and body msg
			
			textmine.setText(msg);							//set body msg   
			DataSource source = new FileDataSource(path);  	//file path converted to Source
			filemine.setDataHandler(new DataHandler(source));//set Source    
			filemine.setFileName("Exit image");				 //	optional file name
			 
			 
			//create Multipart object and add MimeBodyPart objects to this object      
			MimeMultipart multipart = new MimeMultipart();  
			multipart.addBodyPart(textmine);				//body msg set to multipart  
			multipart.addBodyPart(filemine); 				//File attachment set to multipart
						
			message.setContent(multipart);					//bodymsg & attachment send to email content

			Transport.send(message);						//inbluid Method for sending mail

			System.out.println("\n\t Mail Send SuccessFully");	
		} 
		catch (MessagingException e)
		{
			throw new RuntimeException(e);
		}		
	}
}