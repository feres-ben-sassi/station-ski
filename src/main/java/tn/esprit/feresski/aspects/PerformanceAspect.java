package tn.esprit.feresski.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.List;

@Aspect
@Component
@Slf4j
public class PerformanceAspect {
    @Around("execution(* tn.esprit.feresski.services.*.add*(..))")
    public Object executionTime (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch() ;
        stopWatch.start();
        Object o = proceedingJoinPoint.proceed();
        stopWatch.stop();
        log.info("Execution time of {} is {}",
                proceedingJoinPoint.getSignature().getName(),
                stopWatch.getTotalTimeMillis()
        );
       return o ;
    }

    @Around("execution(* tn.esprit.feresski.services.*.getAll*(..))")
    public List<Object> executionTimeList (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch() ;
        stopWatch.start();
        List<Object> list = (List<Object>) proceedingJoinPoint.proceed();
        stopWatch.stop();
        log.info("Execution time of {} is {}",
                proceedingJoinPoint.getSignature().getName(),
                stopWatch.getTotalTimeMillis()
        );
        return list ;
    }
}
