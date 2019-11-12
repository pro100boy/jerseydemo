package com.jersey.mavendemo.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class LogExecutionTime {
    @Around("execution(* com.jersey.mavendemo.*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = point.proceed();

        log.info(String.format(
                "%s.%s execution time: %dms",
                point.getTarget().getClass().getName(),
                point.getSignature().getName(),
                System.currentTimeMillis() - start)
        );
        return result;
    }
}

