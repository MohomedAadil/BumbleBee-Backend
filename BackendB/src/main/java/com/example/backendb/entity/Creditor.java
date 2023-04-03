package com.example.backendb.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "creditor")
public class Creditor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    private int phonenumber;

    public Creditor() {}

    public Creditor(String fullName, Date dateOfBirth) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phonenumber= phonenumber;
    }

    // getters and setters for id, fullName, and dateOfBirth

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }
}
