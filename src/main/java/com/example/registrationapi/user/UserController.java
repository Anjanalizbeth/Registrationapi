package com.example.registrationapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
	@Autowired
    UserRepository userRepository;
    
   @GetMapping("/users/viewall")
   @CrossOrigin(origins = "http://localhost:4200")
   public List<User> findAll() {
   List<User> users = new ArrayList<>();
   userRepository.findAll().forEach(users::add);
   return users;
    }
     		
    @PostMapping("/users/register")
    @CrossOrigin(origins = "http://localhost:4200")
    public Status registerUser(@Valid @RequestBody User newUser) {
        List<User> users = userRepository.findAll();
        System.out.println("New user: " + newUser.toString());
        for (User user : users) {
            System.out.println("Registered user: " + newUser.toString());
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        userRepository.save(newUser);
        return Status.SUCCESS;
    }
   

    

    
    @DeleteMapping("/users/deleteall")
    @CrossOrigin(origins = "http://localhost:4200")
    public Status deleteUsers() {
        userRepository.deleteAll();
        return Status.SUCCESS;
    }
}