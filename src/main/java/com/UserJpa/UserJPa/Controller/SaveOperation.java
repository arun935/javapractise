package com.UserJpa.UserJPa.Controller;

import com.UserJpa.UserJPa.Entity.User;
import com.UserJpa.UserJPa.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/save")
public class SaveOperation {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/emp")
      String saveemp()
    {
       User user1 = new User(1,"arun","software");
        User user2 = new User(2,"aksk","software");
        User user3 = new User(3,"rohit","software");

        List<User>  l1 = new ArrayList<>();
        l1.add(user1);
        l1.add(user2);
        l1.add(user3);
         userRepository.save(user1);
        userRepository.saveAll(l1);
       User u1= userRepository.findById(2).get();
//        System.out.println(u1);
       return "saved";
    }


    @GetMapping ("/getemp/{Id}")
            void getBYid( @PathVariable("Id") int Id)
    {
        User u3= userRepository.findById(Id).get();
        System.out.println(u3);

    }

    @PutMapping("/updateemp/{Id}")
    void updateBYid( @PathVariable("Id") int Id)
    {

      Optional<User> optional = userRepository.findById(Id);
       User user = optional.get();
       user.setName("cheena");
        System.out.println(user);
    }


    @DeleteMapping("/deleteemp/{Id}")
    void deleteBYid( @PathVariable("Id") int Id)
    {
          userRepository.deleteById(Id);
         Iterable<User>  it = userRepository.findAll();
         System.out.println(it);
         it.forEach(System.out::println);

    }

}
