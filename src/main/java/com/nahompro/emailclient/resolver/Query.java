package com.nahompro.emailclient.resolver;

import com.nahompro.emailclient.model.User;
import com.nahompro.emailclient.repo.UserRepo;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Query implements GraphQLQueryResolver {
    private UserRepo userRepo;

    @Autowired
    public Query(UserRepo userRepo){
        log.debug("########> Initializing Query Component");
        this.userRepo=userRepo;
    }

    public User getUserByID(String id){
        log.debug("########> Get User-ID called with id "+id);
        return userRepo.findById(Long.parseLong(id)).orElse(null);
    }
    public Iterable<User> getAllUsers(){
        log.debug("#######> Get all users called");
        return userRepo.findAll();
    }
}
