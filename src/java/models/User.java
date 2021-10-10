package models;

import java.io.Serializable;


public class User implements Serializable {
    
   private String username = "";
   private String password = "";

    public User(String username, Object object) {
        throw new UnsupportedOperationException("Not supported yet.");    
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    
}
