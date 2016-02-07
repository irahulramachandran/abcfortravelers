package com.example.saurab.abc.vo;

/**
 * Created by saurab on 2/6/2016.
 */
public class UserEmailAndPassword {
    String emailID;
    String password;

    public UserEmailAndPassword(String emailID, String password) {
        super();
        this.emailID = emailID;
        this.password = password;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
