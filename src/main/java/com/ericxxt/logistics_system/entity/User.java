package com.ericxxt.logistics_system.entity;

public class User {
    private int user_id;
    private String username;
    private String password;
    private String province;
    private String city;
    private String area;
    private String address;
    private String sex;
    private String phoneNum;


    public User(String username, String password, String province, String city, String area, String address, String sex, String phoneNum) {
        this.username = username;
        this.password = password;
        this.province = province;
        this.city = city;
        this.area = area;
        this.address = address;
        this.sex = sex;
        this.phoneNum = phoneNum;
    }

    public User(int user_id, String username, String password, String province, String city, String area, String address, String sex, String phoneNum) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.province = province;
        this.city = city;
        this.area = area;
        this.address = address;
        this.sex = sex;
        this.phoneNum = phoneNum;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
