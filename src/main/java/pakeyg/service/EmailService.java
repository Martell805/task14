package pakeyg.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pakeyg.entity.Author;
import pakeyg.entity.Book;


@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    @Value("${app.notificationEmail}")
    private String email;

    private final JavaMailSender emailSender;

    @Async
    public void notify(Book book) {
        sendEmail("Book saved", book.toString());
    }

    @Async
    public void notify(Author author) {
        sendEmail("Author saved", author.toString());
    }

    @Async
    public void sendEmail(String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        emailSender.send(simpleMailMessage);

        log.info("Sent notification " + subject);
    }
}
