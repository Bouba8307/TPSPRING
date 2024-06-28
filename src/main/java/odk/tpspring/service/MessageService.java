package odk.tpspring.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final JavaMailSender mailSender;

    public MessageService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String subject, String text, String destEmail) {
        String content = "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<style>" +
                ".email-body { font-family: 'Arial', sans-serif; max-width: 600px; margin: auto; }" +
                ".header { background-color: #f3f3f3; padding: 20px; }" +
                ".content { padding: 20px; }" +
                ".cta-button { display: block; width: 200px; margin: 20px auto; padding: 10px; background-color: #007bff; color: white; text-align: center; text-decoration: none; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class=\"email-body\">" +
                "<div class=\"header\">" + subject + "</div>" +
                "<div class=\"content\">" + text + "</div>" +
                "<a href=\"https://#\" class=\"cta-button\">En Savoir plus</a>" +
                "</div>" +
                "</body>" +
                "</html>";

        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(destEmail);
            helper.setSubject(subject);
            helper.setText(content, true); // true indicates HTML content
            mailSender.send(message);
            System.out.println("Email sent successfully to " + destEmail);
        } catch (MessagingException e) {
            System.err.println("Error sending email: " + e.getMessage());
            // Handle exception as needed, e.g., logging or re-throwing
            throw new RuntimeException("Failed to send email", e); // Optional: re-throw as a runtime exception
        }
    }
}
