package com.nahompro.emailclient.resolver;

import com.nahompro.emailclient.model.User;
import com.nahompro.emailclient.repo.UserRepo;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class UserResolver implements GraphQLQueryResolver {
    private final UserRepo userRepo;
    public UserResolver(UserRepo userRepo){
        this.userRepo=userRepo;
    }
    public User userByID(String id){
        return userRepo.findById(Long.parseLong(id)).orElse(null);
    }
}
