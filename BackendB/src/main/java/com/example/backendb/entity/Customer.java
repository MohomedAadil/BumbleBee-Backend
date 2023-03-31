package com.example.backendb.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.swing.text.DateFormatter;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer_TBL")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "customer_id")
    private Long id;
//    @OneToMany(mappedBy = "customer")
//    private List<Order> orders; // mapped to "customer_id" in the database table
    private String username;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date DOB;
    private String phone;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
