package com.grope6.design.entity;

public class Login {
    private String userid;

    private String userpassword;

    private Integer usertype;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Integer getNusertype() {
        return usertype;
    }

    public void setNusertype(Integer nusertype) {
        this.usertype = nusertype;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userid='" + userid + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", nusertype=" + usertype +
                '}';
    }
}