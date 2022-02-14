package com.slavamashkov.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointcutDeclarationAspect {
    @Pointcut("execution(public * com.slavamashkov.aop.UserDAO.get*(..))")
    public void userDAOGetTrackerPointcut() {
    }

    @Pointcut("execution(public * com.slavamashkov.aop.UserDAO.set*(..))")
    public void userDAOSetTrackerPointcut() {
    }

    @Pointcut("userDAOGetTrackerPointcut() || userDAOSetTrackerPointcut()")
    public void userDAOGetOrSetTrackerPointcut() {
    }

    @Before("userDAOGetOrSetTrackerPointcut()")
    public void userDAOGetOrSetTracker() {
        System.out.println("Logging: Invoke getter or setter");
    }
}
