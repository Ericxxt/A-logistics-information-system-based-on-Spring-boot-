package com.ericxxt.logistics_system.entity;

public class Deliver {
    private int deliver_id;
    private String deliver_name;
    private String password;
    private String province;
    private String status;
    private String news;
    private String orderNum;
    private String salary;
    private String phoneNum;
    private String repository;

    public Deliver(int deliver_id, String deliver_name, String province) {
        this.deliver_id = deliver_id;
        this.deliver_name = deliver_name;
        this.province = province;
    }

    public Deliver(int deliver_id, String deliver_name, String password, String province, String status, String news, String orderNum, String salary, String phoneNum, String repository) {
        this.deliver_id = deliver_id;
        this.deliver_name = deliver_name;
        this.password = password;
        this.province = province;
        this.status = status;
        this.news = news;
        this.orderNum = orderNum;
        this.salary = salary;
        this.phoneNum = phoneNum;
        this.repository=repository;
    }

    public int getDeliver_id() {
        return deliver_id;
    }

    public void setDeliver_id(int deliver_id) {
        this.deliver_id = deliver_id;
    }

    public String getDeliver_name() {
        return deliver_name;
    }

    public void setDeliver_name(String deliver_name) {
        this.deliver_name = deliver_name;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }
}
