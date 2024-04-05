package com.nahompro.emailclient;

import com.nahompro.emailclient.model.User;
import com.nahompro.emailclient.model.UserData;
import com.nahompro.emailclient.repo.UserDataRepo;
import com.nahompro.emailclient.repo.UserRepo;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPATests {
    @Autowired
    UserDataRepo userDataRepo;
    @Autowired
    UserRepo userRepo;

    @Test
    void tryCreateUser(){
        User user=new User();
        Faker faker=new Faker();
        user.setUsername(faker.name().firstName());
        user.setPassword(faker.internet().password());
        user=userRepo.save(user);
        assert(user.getId()>0);
        userRepo.delete(user);
        assert(!userRepo.existsById(user.getId()));
    }
    @Test
    void tryCreateUserWithData(){
        User user=new User();
        UserData userData=new UserData();
        Faker faker=new Faker();
        userData.setEmail(faker.internet().emailAddress());
        userData.setPhone(faker.phoneNumber().cellPhone());
        userData.setFirstName(faker.name().firstName());
        userData.setLastName(faker.name().lastName());
        user.setUserData(userData);
        user=userRepo.save(user);
        assert(user.getId()>0);
        assert(user.getUserData().getId()>0);
        userRepo.delete(user);
        assert(!userRepo.existsById(user.getId()));
        assert(!userDataRepo.existsById(user.getUserData().getId()));
    }
}
