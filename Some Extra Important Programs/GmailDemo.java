// smtp = Simple Mail Transfer Protocol

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

class GmailDemo
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
				return new PasswordAuthentication(from, "Your Email Pass "); //email and pass of sender
			}
		  });  
		try 
		{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));		//from = Sender email adress Declared At Top
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));					//to = reciever email adress Declared At Top
			message.setSubject(sub);						//sub = email Subject Declared At Top
			message.setText(msg);							//msg = email Msg Declared At Top	

			Transport.send(message);						//inbluid Method for sending mail

			System.out.println("\n\t Mail Send SuccessFully");	
		} 
		catch (MessagingException e)
		{
			throw new RuntimeException(e);
		}		
	}
}