package pakeyg.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pakeyg.entity.Author;
import pakeyg.entity.Book;
import pakeyg.service.EmailService;

@Order(200)
@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class EmailNotificationAspect {
    private final EmailService emailService;

    @AfterReturning(pointcut = "@annotation(pakeyg.annotation.Notify)", returning = "savedBook")
    public void notifyEmail(Book savedBook) {
        emailService.notify(savedBook);
    }

    @AfterReturning(pointcut = "@annotation(pakeyg.annotation.Notify)", returning = "savedAuthor")
    public void notifyEmail(Author savedAuthor) {
        emailService.notify(savedAuthor);
    }
}
