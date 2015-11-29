package com.epam.brest.course2015.social.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by alexander on 22.11.15.
 */

@Aspect
public class SocialTestLogger {

    @Around("execution(* *(..)) && @annotation(TestLogged)")
        public Object around(ProceedingJoinPoint point) throws Throwable {
        String classname = point.getStaticPart().getSignature().getDeclaringTypeName();
        long start = System.currentTimeMillis();
            Object result = point.proceed();
        Logger logger = LogManager.getLogger(classname);
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
        }
}
