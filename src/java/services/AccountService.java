package services;

import models.User;

import java.io.Serializable;

public class AccountService implements Serializable {

    private String abe = "abe";
    private String barb = "bard";
    private String password = "password";

    public User login(String username, String password) {
        if ((username.equals("abe")) || (username.equals("barb")) && (password.equals("password"))) {
            return new User(username, null);
        } else {
            return null;
        }
    }

}
