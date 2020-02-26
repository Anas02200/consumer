package com.test.Kadmin.jpaRepos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.test.Kadmin.entities.UserEntity;

@RepositoryRestResource
public interface UserRepo extends JpaRepository<UserEntity, String> {


	
}
