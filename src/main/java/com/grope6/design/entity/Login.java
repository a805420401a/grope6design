package com.grope6.design.entity;

public class Login {
    private String userid;

    private String userpassword;

    private int usertype;

    public Login(String userid, String userpassword, int usertype) {
        this.userid = userid;
        this.userpassword = userpassword;
        this.usertype = usertype;
    }

    public Login() {
    }

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

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int nusertype) {
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