package com.ecommerce.model;

public class User {
    private String fullName;
    private String staffId;
    private int id;
    private String email;
    private String password;

    public User() {
    }

    public User(String fullName, String staffId, int id, String password, String email) {
        this.fullName = fullName;
        this.staffId = staffId;
        this.id = id;
        this.password = password;
        this.email = email;
    }

    public User(String fullName, String staffId, String password, String email) {
        this.fullName = fullName;
        this.staffId = staffId;
        this.password = password;
        this.email = email;
    }

    public User(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public User(String fullName, int id, String email, String password) {
        this.fullName = fullName;
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                "fullName='" + fullName + '\'' +
                ", staffId='" + staffId + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
