package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class EmailSender {

    // --- Gmail credentials ---
    private static final String ROOT_EMAIL = "may1024ank@gmail.com";
    private static final String ROOT_PASS = "ycjk rzhx rigr nxuj";  // App Password
    private static final String TO_EMAIL = "forugpt2@gmail.com";

    // --- File paths ---
    private static final String PATH_FILE = "C:/Users/mayan/Desktop/testing.txt";
    private static final String LOG_FILE = "C:/Users/mayan/Desktop/logging.log";

    public static void main(String[] args) {
        new EmailSender().sendEmail();
    }

    public void sendEmail() {
        File file = new File(PATH_FILE);
        String date = new Date().toString();

        if (file.exists()) {
            log(date + ": File found, sending email...");

            // Configure mail properties
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            // Authenticate session
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(ROOT_EMAIL, ROOT_PASS);
                }
            });

            try {
                // Create message
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(ROOT_EMAIL));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(TO_EMAIL));
                message.setSubject("Auto Mail: File found");
                message.setSentDate(new Date());

                // Message body
                MimeBodyPart textPart = new MimeBodyPart();
                textPart.setText("Here is your requested file.");

                // Attachment
                MimeBodyPart attachmentPart = new MimeBodyPart();
                attachmentPart.attachFile(file);

                // Combine parts
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(textPart);
                multipart.addBodyPart(attachmentPart);
                message.setContent(multipart);

                // Send email
                Transport.send(message);
                log(date + ": Email sent successfully.");

            } catch (Exception e) {
                log(date + ": Failed to send email. Error: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            log(date + ": File not found at " + PATH_FILE);
        }
    }

    private void log(String text) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            fw.write(text + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
