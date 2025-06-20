package com.sge.view;

import com.sge.model.User;
import com.sge.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class UserController {

    @Inject
    private UserService userService;

    private List<User> users;

    @PostConstruct
    public void init() {
        users = userService.findAll();
    }

    public List<User> getUsers() {
        return users;
    }
}
