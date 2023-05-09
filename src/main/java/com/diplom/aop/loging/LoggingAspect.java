package com.diplom.aop.loging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(100)
@Component
@Aspect
public class LoggingAspect {

    @Pointcut("within(com.diplom.service..*)")
    public void serviceMethods() {
        //service method pointcut
    }

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController com.diplom.controller..*)")
    public void controllerMethods() {
        //controller method pointcut
    }

    @Pointcut("this(org.springframework.data.jpa.repository.JpaRepository+)")
    public void repositoryMethods() {
        //repository method pointcut
    }

    @Before("(serviceMethods() || repositoryMethods())")
    public void logExecution(JoinPoint joinPoint) {
        //todo add service/repo logs

    }

    @Before("controllerMethods()")
    public void logControllerInfo(JoinPoint joinPoint) {
        //todo add controller logs
    }
}
