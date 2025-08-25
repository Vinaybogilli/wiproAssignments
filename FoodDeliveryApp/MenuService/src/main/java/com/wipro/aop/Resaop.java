package com.wipro.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class Resaop {

    @Before("execution(* com.wipro.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Method is implementing");
    }
}