package com.example.service;

import com.example.entity.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {

    private final static Properties properties2 = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/service.properties");
            properties2.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendMail(Employee emp) {

        // Recipient's email ID needs to be mentioned.
        String to = emp.getEmail();

        // Sender's email ID needs to be mentioned
        String from = properties2.getProperty("service.from");
        // Sender's password needs to be mentioned to get connection
        String password=properties2.getProperty("service.password");

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, password);

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Hello "+emp.getFirstName()+"! Here are your work credentials");

            // Now set the actual message
            message.setText("Your username to log in is: "+emp.getEmail()+"\nYour temporary password is: "+emp.getPassword());

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}

/*public class JavaMailUtil {

    private static final Logger LOG= Logger.getLogger("ers");

    public static void sendMail(String recepient) throws Exception{
        System.out.println("Preparing to send email:");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "vremailfromjava@gmail.com";
        String password = "LetsGoJava2022!";

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recepient);

        Transport.send(message);
        System.out.println("Message sent successfully!");


    //    mail.smtp.auth
      //  mail.smtp.starttls.enable
    //    mail.smtp.host - smtp.gmail.com
      //  mail.smtp.port - 587
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("My First Email from Java App");
            message.setText("Hey There, \n Look my email!");
            return message;
        }catch(MessagingException e){
            LOG.error("error sending email");
            e.printStackTrace();
        }
        return null;

    }

            <dependency>
            <groupId>javax.mail</groupId>
            <artifactId>javax.mail-api</artifactId>
            <version>1.6.2</version>
        </dependency>
}*/
