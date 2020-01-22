package com.springboot.elk.model;

import java.util.Date;

public class DemoUser {
    private int id;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DemoUser() {
    }

    public DemoUser(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;

    }
    @Override
    public String toString() {
        return "DemoUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
