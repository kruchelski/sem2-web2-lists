package com.ufpr.tads.web2.beans;

import java.io.Serializable;

public class LoginBean implements Serializable {
    private int id;
    private String login;
    
    public LoginBean() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
