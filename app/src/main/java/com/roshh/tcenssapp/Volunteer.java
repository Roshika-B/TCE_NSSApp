package com.roshh.tcenssapp;

public class Volunteer {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String bloodgrp;

//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }

//    private String gender;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBloodgrp() {
        return bloodgrp;
    }

    public void setBloodgrp(String bloodgrp) {
        this.bloodgrp = bloodgrp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Volunteer() {}
    public Volunteer(String name, String email, String password, String phone, String bloodgrp, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.bloodgrp = bloodgrp;
        this.age = age;
    }




}
