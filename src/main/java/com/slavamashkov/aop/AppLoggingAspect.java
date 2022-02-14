package com.slavamashkov.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppLoggingAspect {
    @Before("execution(public void com.slavamashkov.aop.UserDAO.addUser())")
    public void aopTestMethod() {
        System.out.println("Test code");
    }
}
