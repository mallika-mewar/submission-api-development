/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.UserAPI;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alina
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    private UserDatabase db = UserDatabase.getInstance();
    
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(this.db.getUsers(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id){
        Optional<User> user = this.db.getUser(id);
        
        if(user.isPresent()){
            return new ResponseEntity<User>(user.get(),HttpStatus.OK);
        }else{
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("User with id " + id + "was not found.");
        }
    }
    
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User input){
        User newUser = new User(input.getFirstname(),input.getLastname(),input.getPwd(),input.getMail());
        
        this.db.addUser(newUser);
        return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserEmail(@PathVariable("id")Long id,@RequestParam("mail") String mail){
        Optional<User> user = this.db.getUser(id);
        
        if(user.isPresent()){
            user.get().setMail(mail);
            return new ResponseEntity<User>(user.get(),HttpStatus.OK);
        }else{
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("User with id " + id + "was not found.");
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        boolean userDeleted = this.db.deleteUser(id);
        if(userDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("User with id " + id + "deleted successfully.");
        }else{
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("User with id " + id + "was not found.");
        }
    }
}
