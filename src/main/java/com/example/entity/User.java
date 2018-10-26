package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String tele;
    private String email;

    public User() {
    }

    public User(int id, String name, String address, String tele, String email) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setTele(tele);
        this.setEmail(email);
    }

    public User(String name, String address, String tele, String email) {
        this.setName(name);
        this.setAddress(address);
        this.setTele(tele);
        this.setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tele='" + tele + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
