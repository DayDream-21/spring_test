package com.slavamashkov.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AOPConfig.class)) {

            //TestBean testBean = context.getBean("testBean", TestBean.class);
            UserDAO userDAO = context.getBean("userDAO", UserDAO.class);

            /*userDAO.addUser();
            userDAO.deleteUser();
            userDAO.findAll();
            userDAO.setX(10);*/

            /*List<String> list = userDAO.getAllUsers();
            System.out.println(list);

            userDAO.longOperation();*/

            /*userDAO.setX(10);
            System.out.println(userDAO.getX());*/
        }
    }
}
