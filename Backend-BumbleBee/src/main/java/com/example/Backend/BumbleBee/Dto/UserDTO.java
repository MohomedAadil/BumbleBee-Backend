package com.example.Backend.BumbleBee.Dto;

import javax.persistence.Column;

public class UserDTO {
    private int userid;
    private String fullname;
    private String username;
    private String dob;
    private String phonenumber;
    private String password;

    public UserDTO(int userid, String fullname, String username, String dob, String phonenumber, String password) {
        this.userid = userid;
        this.fullname = fullname;
        this.username = username;
        this.dob = dob;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    public UserDTO() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
