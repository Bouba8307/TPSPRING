package odk.tpspring.controller;

import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import odk.tpspring.model.Message;
import odk.tpspring.service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notif")
@AllArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody Message message) throws MessagingException {
        String subject = message.getSubject();
        String text = message.getText();
        String destEmail = message.getDest_email();

        messageService.sendEmail(subject, text, destEmail);
        return "Email sent successfully";
    }
}
