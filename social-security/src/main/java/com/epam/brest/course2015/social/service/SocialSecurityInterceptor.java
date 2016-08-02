package com.epam.brest.course2015.social.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

/**
 * Created by alexander_borohov on 25.7.16.
 */
@Aspect
@Component
public class SocialSecurityInterceptor {
    private static final Logger LOGGER =
    LogManager.getLogger(SocialSecurityInterceptor.class.getName());
    @Value("${role.admin}")
    private String roleAdmin;
    @Value("${role.user}")
    private String roleUser;
    @Value("${role.temp}")
    private String roleTemp;

    public SocialSecurityInterceptor() {}

    @Autowired
    private SocialSecurity socialSecurity;

    @Pointcut("execution(@com.epam.brest.course2015.social.service.SocialSecured * * (..))")
    private void checkToken() {}

    @Around("checkToken()")
    private Object executeCheck(ProceedingJoinPoint joinPoint) throws Throwable
    {
        LOGGER.info("Intercepting a checkToken process");
        Object[] argz = joinPoint.getArgs();
        String token = getToken(argz, joinPoint);
        if (token != null && socialSecurity.isTokenValid(token, roleUser, roleAdmin)) {
            LOGGER.info("Token is valid: {}", token);
            return joinPoint.proceed();
        }
        LOGGER.info("Token is invalid: {}", token);

        return null;
    }

    private String getToken(Object[] argz, ProceedingJoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (Annotation an: parameterAnnotations[i]) {
                if (an instanceof RequestBody && argz[i] instanceof String) {
                    return (String ) argz[i];
                }
            }
        }
        return null;
    }
}
