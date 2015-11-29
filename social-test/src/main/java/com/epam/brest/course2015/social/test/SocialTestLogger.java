package com.epam.brest.course2015.social.test;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Arrays;

/**
 * Created by alexander on 22.11.15.
 */

@Aspect
public class SocialTestLogger {

    @Around("execution(* *(..)) && @annotation(TestLogged)")
        public Object around(ProceedingJoinPoint point) throws Throwable {
            long start = System.currentTimeMillis();
            Object result = point.proceed();
        Logger logger = LogManager.getLogger();
        logger.info(
                    "#%s(%s): %s in %[msec]s",
                    MethodSignature.class.cast(point.getSignature()).getMethod().getName(),
                    point.getArgs(),
                    result,
                    System.currentTimeMillis() - start
            );
            return result;
        }
}
