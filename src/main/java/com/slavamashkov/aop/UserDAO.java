package com.slavamashkov.aop;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Component
public class UserDAO {
    int x;

    public void addUser() {
        System.out.println("New user created");
    }

    public void deleteUser() {
        System.out.println("User deleted");
    }

    public void updateUser() {
        System.out.println("User updated");
    }

    public void findAll() {
        System.out.println("All users founded");
    }

    public void findUserById(Long id) {
        System.out.printf("User with id: %d founded", id);
    }

    public List<String> getAllUsers() {
        return new ArrayList<>(Arrays.asList("Bob", "Alex", "Jack"));
    }

    public void longOperation() {
        System.out.println("Begin long operation");
        try {
            Thread.sleep(500);
        } catch (InterruptedException exception)  {
            exception.printStackTrace();
        }
        System.out.println("Finish long operation");
    }
}
