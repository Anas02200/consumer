package com.test.Kadmin.jpaRepos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.test.Kadmin.entities.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long> {


    UserEntity findUserEntityByIdentityCardNumber(String identityCardNumber);

    boolean existsUserEntityByIdentityCardNumberAndToken(String identityCardNumber,String token);


	
}
