package com.example.Backend.BumbleBee.Entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;

    @Column(name = "full_name", length = 400)
    private String fullname;

    @Column(name = "user_name", length = 255)
    private String username;

    @Column(name = "DOB", length = 255)
    private String dob;

    @Column(name = "phone_number", length = 255)
    private String phonenumber;

    @Column(name = "password", length = 255)
    private String password;

    public User(int userid, String fullname, String username, String dob, String phonenumber, String password) {
        this.userid = userid;
        this.fullname = fullname;
        this.username = username;
        this.dob = dob;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    public User() {
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

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", fullname='" + fullname + '\'' +
                ", username='" + username + '\'' +
                ", dob='" + dob + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
