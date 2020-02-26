package com.test.Kadmin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.test.Kadmin.entities.UserEntity;
import com.test.Kadmin.jpaRepos.UserRepo;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	
	@Bean
	CommandLineRunner start(UserRepo user) {
		return args->{
			user.save(new UserEntity("anaas", 15555));
		};
		
	}

}
