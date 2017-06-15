/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.UserAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author alina
 */
public class UserDatabase {
    private Map<Long,User> users = new HashMap<>();
    
    private static UserDatabase instance;
    
    private UserDatabase(){
        this.addUser(new User("Max","Mustermann","test","max@mustermann.de"));
        this.addUser(new User("Lischen","Müller","test1","lischen@mueller.de"));
        this.addUser(new User("Ben","Meier","test2","ben@meier.de"));
    }
    
    public static UserDatabase getInstance(){
        if(instance==null){
            instance = new UserDatabase();
        }
        return instance;
    }
    
    public Optional<User> getUser(Long id){
        if(this.users.containsKey(id)){
            return Optional.of(this.users.get(id));
        }else{
            return Optional.empty();
        }
    }
    
    public List<User> getUsers(){
        return new ArrayList<>( this.users.values());
    }
    
    public void addUser(User user){
        this.users.put(user.getId(), user);
    }
    
    public boolean deleteUser(Long id){
        if(this.users.containsKey(id)){
            this.users.remove(id);
            return true;
        }else{
            return false;
        }
    }
    
}
