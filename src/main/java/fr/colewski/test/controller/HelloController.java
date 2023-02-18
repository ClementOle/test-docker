package fr.colewski.test.controller;

import fr.colewski.test.dao.UserDao;
import fr.colewski.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping(value = "/user")
    public List<User> getUser() {
        return userDao.findAll();
    }

    @PostMapping(value = "/user/new", consumes = "application/json", produces = "application/json")
    public User save(User user) {
        return userDao.save(user);
    }
}
