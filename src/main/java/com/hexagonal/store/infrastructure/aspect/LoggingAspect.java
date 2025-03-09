package com.hexagonal.store.infrastructure.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("execution(* com.hexagonal.store.infrastructure.input.rest.*Controller.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        
        log.info("Entering: {}.{}", className, methodName);
        Instant start = Instant.now();
        
        try {
            Object result = joinPoint.proceed();
            Duration timeElapsed = Duration.between(start, Instant.now());
            
            log.info("Success: {}.{} completed in {} ms", 
                    className, methodName, timeElapsed.toMillis());
            
            return result;
        } catch (Exception e) {
            log.error("Error in {}.{}: {}", 
                    className, methodName, e.getMessage(), e);
            throw e;
        }
    }
}
