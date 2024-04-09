package com.nahompro.emailclient.resolver;

import com.nahompro.emailclient.model.User;
import com.nahompro.emailclient.model.UserData;
import com.nahompro.emailclient.repo.UserDataRepo;
import com.nahompro.emailclient.repo.UserRepo;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Mutation implements GraphQLMutationResolver {
    private final UserRepo userRepo;
    private final UserDataRepo userDataRepo;

    @Autowired
    public Mutation(UserDataRepo userDataRepo, UserRepo userRepo){
        this.userRepo=userRepo;
        this.userDataRepo=userDataRepo;
    }
    public User saveUser(User user){
        log.debug("#######>User save request: "+user.getUsername());
        return userRepo.save(user);
    }
    public boolean deleteUserByID(String id){
        log.debug("#######> Delete user request with id: "+id);
        userRepo.deleteById(Long.parseLong(id));
        return true;
    }
    public boolean deleteUser(User user){
        log.debug("######## delete user request with username: "+user.getUsername());
        userRepo.delete(user);
        return true;
    }
}
