package com.qart.todo.utils;

import com.github.javafaker.Faker;
import com.qart.todo.objects.User;

public class UserUtils {

    public static User generateRandomUser(){
        String firstName= new Faker().name().firstName();
        String lastName= new Faker().name().lastName();
        String email= new Faker().internet().emailAddress();
        String pass= new Faker().internet().password();

        User user=new User(email,firstName,lastName,pass);
     return user;

    }
}
