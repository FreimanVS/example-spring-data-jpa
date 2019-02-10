package com.vfreiman.lessons.springdataexamples;

import com.vfreiman.lessons.springdataexamples.builders.UserBuilder;
import com.vfreiman.lessons.springdataexamples.dao.UserDAO;
import com.vfreiman.lessons.springdataexamples.entities.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDataExample {

    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfiguration.class)) {
            UserDAO userDAO = context.getBean(UserDAO.class, "userDAO");

            userDAO.save(new UserBuilder().setName("name1").setPassword("password1").build());
            userDAO.save(new UserBuilder().setName("name2").setPassword("password2").build());

            System.out.println("GET ALL USERS: ");
            userDAO.findAll().forEach(System.out::println);
            System.out.println("==========================");

            System.out.println("GET USER BY ID 1" + userDAO.getOne(1L));
            System.out.println("==========================");

            User user = userDAO.getOne(1L);
            user.setName("updatedName");
            user.setPassword("updatedPassword");
            userDAO.save(user);
            System.out.println("UPDATE USER BY ID 1" + userDAO.getOne(1L));
            System.out.println("==========================");

            System.out.println("DELETE USER BY ID 1");
            userDAO.deleteById(1L);
            System.out.println("ALL USERS: ");
            userDAO.findAll().forEach(System.out::println);
        }
    }
}
