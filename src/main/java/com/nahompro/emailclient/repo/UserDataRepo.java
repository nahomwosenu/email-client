package com.nahompro.emailclient.repo;

import com.nahompro.emailclient.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepo extends JpaRepository<UserData,Long> {
}
