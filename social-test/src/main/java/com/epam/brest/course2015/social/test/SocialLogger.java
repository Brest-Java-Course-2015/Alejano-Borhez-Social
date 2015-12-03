package com.epam.brest.course2015.social.test;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by alexander on 22.11.15.
 */

@Aspect
@Component
public class SocialLogger {

    private static final Logger LOGGER =
            LogManager.getLogger(SocialLogger.class.getName());

    @Pointcut("execution(@com.epam.brest.course2015.social.test.Logged * *(..)) && @annotation(logged)")
    public void setLogged(Logged logged) {}

    @Around("setLogged(logged)")
    public Object log(ProceedingJoinPoint joinPoint,
                      Logged logged) throws Throwable {
        String clazz = joinPoint.getSignature().getDeclaringTypeName();
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        boolean returnVoid = joinPoint.getSignature()
                .toShortString().contains("void");

        Object result;
        long executionTime;

        try {
            long startTime = System.nanoTime();
            result = joinPoint.proceed();
            executionTime = System.nanoTime() - startTime;
        } catch (Exception exception) {
            LOGGER.error("{} #{}{}: {}",
                    clazz,
                    method,
                    args,
                    exception);
            LOGGER.catching(Level.ERROR, exception.getCause());
            throw exception;
        }
        if (returnVoid)
            LOGGER.info("{} #{}{} in {} μsec",
                    clazz,
                    method,
                    args,
                    executionTime / 1000);
        else if (result == null)
            LOGGER.info("{} #{}{} => {} in {} μsec",
                    clazz,
                    method,
                    args,
                    result,
                    executionTime / 1000);
        else {
            String resultClass = result.getClass().getSimpleName();
            LOGGER.info("{} #{}{} => {}: {} in {} μsec",
                    clazz,
                    method,
                    args,
                    resultClass,
                    result,
                    executionTime / 1000);
        }
        return result;
    }
}
