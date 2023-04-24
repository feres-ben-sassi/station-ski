package tn.esprit.feresski.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public * tn.esprit.feresski.services.*.*(..)) ")
    public void inMethod (JoinPoint joinPoint ){
        log.info("in Method"+joinPoint.getSignature().getName());
    }
    @After("execution(public * tn.esprit.feresski.services.*.*(..)) ")
    public void outOfMethod (JoinPoint joinPoint ){
        log.info("Out of Method"+joinPoint.getSignature());
    }
}
