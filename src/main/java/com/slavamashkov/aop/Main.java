package com.slavamashkov.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AOPConfig.class)) {

            //TestBean testBean = context.getBean("testBean", TestBean.class);
            UserDAO userDAO = context.getBean("userDAO", UserDAO.class);

            System.out.println(userDAO.getAllUsers());
            userDAO.setX(13);
            userDAO.deleteUser();
            userDAO.updateUser();
        }


    }
}
