package com.ericxxt.logistics_system.entity;

public class Manager {
    private int manager_id;
    private String manager_name;
    private String password;
    private String phoneNum;
    private String rank;
    private String order_num;
    private String salary;
    private String news;

    public Manager(int manager_id, String manager_name, String password, String phoneNum, String rank, String order_num, String salary, String news) {
        this.manager_id = manager_id;
        this.manager_name = manager_name;
        this.password = password;
        this.phoneNum = phoneNum;
        this.rank = rank;
        this.order_num = order_num;
        this.salary = salary;
        this.news = news;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
