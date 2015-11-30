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
public class SocialTestLogger {

    private static final Logger logger =
            LogManager.getLogger();

    @Pointcut("execution(@com.epam.brest.course2015.social.test.TestLogged * *(..)) && @annotation(testLogged)")
    public void setTestLogged(TestLogged testLogged) {}

    @Around("setTestLogged(testLogged)")
    public Object log(ProceedingJoinPoint joinPoint, TestLogged testLogged) throws Throwable {
        String clazz = joinPoint.getSignature().getDeclaringTypeName();
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        boolean returnVoid = joinPoint.getSignature().toShortString().contains("void");

        Object result;
        long executionTime;

        try {
            long startTime = System.nanoTime();
            result = joinPoint.proceed();
            executionTime = System.nanoTime() - startTime;
        } catch (Exception exception) {
            logger.error("{} #{}{}: {}", clazz, method, args, exception);
            logger.catching(Level.ERROR, exception);
            throw exception;
        }
        if (returnVoid)
            logger.info("{} #{}{} in {} ms", clazz, method, args, executionTime / 1000);
        else if (result == null)
            logger.info("{} #{}{} => {} in {} ms", clazz, method, args, result,
                    executionTime / 1000);
        else {
            String resultClass = result.getClass().getSimpleName();
            logger.info("{} #{}{} => {}: {} in {} μsec", clazz, method, args, resultClass, result,
                    executionTime / 1000);
        }
        return result;
    }

    /* public Object around(ProceedingJoinPoint point) throws Throwable {
        String classname = point.getStaticPart().getSignature().getDeclaringTypeName();
        long start = System.currentTimeMillis();
            Object result = point.proceed();
        logger.debug(
                    MethodSignature.class
                            .cast(point.getSignature())
                            .getMethod()
                            .getName()
                            + ", "
                            + point.getArgs()
                            + ", "
                            + result
                            + ", "
                            + (System.currentTimeMillis() - start)
            );
            return result;
        }*/
}
