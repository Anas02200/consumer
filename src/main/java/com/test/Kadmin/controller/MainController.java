package com.test.Kadmin.controller;

import com.test.Kadmin.entities.UserEntity;
import com.test.Kadmin.jpaRepos.UserRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api")
public class MainController {


    @Autowired
    UserRepo userRepo;


    @RequestMapping(value = "/userEntities", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity saveNewUser(@RequestBody UserEntity userEntity){
        if(!userRepo.existsUserEntityByIdentityCardNumberAndToken(userEntity.getIdentityCardNumber(),userEntity.getToken())){
            userRepo.save(userEntity);
            return ResponseEntity.status(200).body(userEntity);

        }
        else {
            System.out.println("USER EXISTS");
            return ResponseEntity.status(400).body("USER EXISTS");
        }

    }
}
