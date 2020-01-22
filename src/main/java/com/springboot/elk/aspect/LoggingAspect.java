package com.springboot.elk.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Around("execution(* com.springboot.elk.controller..*(..)))")
    public Object log(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            log.info("REQUEST | METHOD: " + request.getMethod() + " - REMOTE: " + request.getRemoteAddr() + " URI: " + request.getRequestURI() + " BODY: " + Arrays.toString(proceedingJoinPoint.getArgs()));
            log.info("RESPONSE | METHOD: " + request.getMethod() + " - REMOTE: " + request.getRemoteAddr() + " - URI: " + request.getRequestURI() + " - BODY: " + value);
        }
        return value;
    }
}
