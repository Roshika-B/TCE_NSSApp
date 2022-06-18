package com.roshh.tcenssapp;

public class PatientDetail {
    private String Name;
    private int age;
    private String mobilenum;
    private String bloodgrp;
    private String hosp;

    public PatientDetail(){}
    public PatientDetail(String name, int age, String mobilenum, String bloodgrp, String hosp) {
        this.Name = name;
        this.age = age;
        this.mobilenum = mobilenum;
        this.bloodgrp = bloodgrp;
        this.hosp = hosp;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return age;
    }

    public String getMobilenum() {
        return mobilenum;
    }

    public String getBloodgrp() {
        return bloodgrp;
    }

    public String getHosp() {
        return hosp;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMobilenum(String mobilenum) {
        this.mobilenum = mobilenum;
    }

    public void setBloodgrp(String bloodgrp) {
        this.bloodgrp = bloodgrp;
    }

    public void setHosp(String hosp) {
        this.hosp = hosp;
    }
}
