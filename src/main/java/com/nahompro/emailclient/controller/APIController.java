package com.nahompro.emailclient.controller;

import com.nahompro.emailclient.model.User;
import com.nahompro.emailclient.repo.UserDataRepo;
import com.nahompro.emailclient.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class APIController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserDataRepo userDataRepo;

    @GetMapping("/")
    public String index(){
        return "<h1>It works </h1>";
    }

    @QueryMapping
    public User userByID(@Argument Long id){
        return userRepo.findById(id).orElse(new User());
    }
}
