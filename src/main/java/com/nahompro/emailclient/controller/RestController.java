package com.nahompro.emailclient.controller;

import com.nahompro.emailclient.repo.UserDataRepo;
import com.nahompro.emailclient.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserDataRepo userDataRepo;

    @GetMapping("/")
    public String get(){
        return "It works!";
    }
}
