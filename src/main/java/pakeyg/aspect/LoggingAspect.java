package pakeyg.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(100)
@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* pakeyg.controller.AuthorController.*(..))")
    public Object logAuthorMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Started author endpoint {}", joinPoint.getSignature().getName());
        Object proceed = joinPoint.proceed();
        log.info("Ended author endpoint {}", joinPoint.getSignature().getName());

        return proceed;
    }

    @Around("execution(* pakeyg.controller.BookController.*(..))")
    public Object logBookMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Started book endpoint {}", joinPoint.getSignature().getName());
        Object proceed = joinPoint.proceed();
        log.info("Ended book endpoint {}", joinPoint.getSignature().getName());

        return proceed;
    }
}
