package com.slavamashkov.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AppLoggingAspect {
    @Before("execution(public void com.slavamashkov.aop.UserDAO.addUser())")
    public void aopTestMethod() {
        System.out.println("Logging: Test code");
    }

    @Before("execution(public void com.slavamashkov.aop.UserDAO.*User())")
    public void beforeAnyModificationMethodOnUserDAO() {
        System.out.println("Logging: Modifying user");
    }

    @Before("execution(public * com.slavamashkov.aop.UserDAO.*(..))")
    public void beforeAnyMethodInAOP(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Logging: Invoke method " + methodSignature);
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            System.out.print("Arguments: ");
            for(Object obj : args) {
                System.out.print(obj.getClass().getTypeName() + " = " + obj);
            }
        }
        System.out.println();
    }

    @AfterReturning(
            pointcut = "execution(public * com.slavamashkov.aop.UserDAO.getAllUsers())",
            returning = "result"
    )
    public void trap(List<String> result) {
        result.set(0, "Ha-Ha-Ha-Ha");
    }

    @Around("execution(public void com.slavamashkov.aop.UserDAO.longOperation())")
    public Object timer(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Logging: Long operation has started");

        long start = System.currentTimeMillis();

        Object out = proceedingJoinPoint.proceed();

        long finish = System.currentTimeMillis();
        long duration = finish - start;

        System.out.println(proceedingJoinPoint.getSignature() + ": duration = " + duration);
        System.out.println("Logging: Long operation has finished");

        return out;
    }
}
