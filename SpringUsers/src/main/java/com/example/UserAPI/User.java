/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.UserAPI;

/**
 *
 * @author alina
 */
public class User {
    private long id;
    private String firstname;
    private String lastname;
    private String pwd;
    private String mail;
    
    private static long autoincrement = 1;

    public User(String firstname, String lastname, String pwd, String mail) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pwd = pwd;
        this.mail = mail;
        this.id = autoincrement;
        autoincrement++;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
}
