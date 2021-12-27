package com.chau.domain;

import java.util.Date;

/**
 * @author wilfred
 */
public class User {

    private int id;
    private String username;
    private String telephone;
    private Date birthday;
    private String gender;
    private String address;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public User() {
    }

    public User(int id, String username, String telephone, Date birthday, String gender, String address) {
        this.id = id;
        this.username = username;
        this.telephone = telephone;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
