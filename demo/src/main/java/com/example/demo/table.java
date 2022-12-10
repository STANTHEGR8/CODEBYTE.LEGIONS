package com.example.demo;

public class table {
    private String name;
    private Integer uid;
    private String email;
    private Integer mobile;
    private String bloodGroup;

    public table(String name, Integer uid, String email, Integer mobile, String bloodGroup) {
        this.name = name;
        this.uid = uid;
        this.email = email;
        this.mobile = mobile;
        this.bloodGroup = bloodGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}