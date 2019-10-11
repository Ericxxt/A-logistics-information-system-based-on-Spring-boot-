package com.ericxxt.logistics_system.entity;

public class Order {
    private int order_id;
    private String order_name;
    private String order_type;
    private int sender_id;
    private String sender_name;
    private String sender_province;
    private String sender_city;
    private String sender_area;
    private String sender_address;
    private String sender_phone;
    private int receiver_id;
    private String receiver_name;
    private String receiver_province;
    private String receiver_city;
    private String receiver_area;
    private String receiver_address;
    private String receiver_phone;
    private int manager_id;
    private int deliver_id;
    private String initial_time;
    private String live_time;
    private String status;
    private String price;
    private String volume;
    private String trans_info;

    public Order(int order_id, String order_name, String order_type, int sender_id, String sender_name, String sender_province, String sender_city, String sender_area, String sender_address, String sender_phone, int receiver_id, String receiver_name, String receiver_province, String receiver_city, String receiver_area, String receiver_address, String receiver_phone, int manager_id, int deliver_id, String initial_time, String live_time, String status, String price, String volume, String trans_info) {
        this.order_id = order_id;
        this.order_name = order_name;
        this.order_type = order_type;
        this.sender_id = sender_id;
        this.sender_name = sender_name;
        this.sender_province = sender_province;
        this.sender_city = sender_city;
        this.sender_area = sender_area;
        this.sender_address = sender_address;
        this.sender_phone = sender_phone;
        this.receiver_id = receiver_id;
        this.receiver_name = receiver_name;
        this.receiver_province = receiver_province;
        this.receiver_city = receiver_city;
        this.receiver_area = receiver_area;
        this.receiver_address = receiver_address;
        this.receiver_phone = receiver_phone;
        this.manager_id = manager_id;
        this.deliver_id = deliver_id;
        this.initial_time = initial_time;
        this.live_time = live_time;
        this.status = status;
        this.price = price;
        this.volume = volume;
        this.trans_info = trans_info;
    }

    public Order(String order_name, String order_type, int sender_id, String sender_name, String sender_province, String sender_city, String sender_area, String sender_address, String sender_phone, int receiver_id, String receiver_name, String receiver_province, String receiver_city, String receiver_area, String receiver_address, String receiver_phone,String price) {
        this.order_name = order_name;
        this.order_type = order_type;
        this.sender_id = sender_id;
        this.sender_name = sender_name;
        this.sender_province = sender_province;
        this.sender_city = sender_city;
        this.sender_area = sender_area;
        this.sender_address = sender_address;
        this.sender_phone = sender_phone;
        this.receiver_id = receiver_id;
        this.receiver_name = receiver_name;
        this.receiver_province = receiver_province;
        this.receiver_city = receiver_city;
        this.receiver_area = receiver_area;
        this.receiver_address = receiver_address;
        this.receiver_phone = receiver_phone;
        this.price=price;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getSender_province() {
        return sender_province;
    }

    public void setSender_province(String sender_province) {
        this.sender_province = sender_province;
    }

    public String getSender_city() {
        return sender_city;
    }

    public void setSender_city(String sender_city) {
        this.sender_city = sender_city;
    }

    public String getSender_area() {
        return sender_area;
    }

    public void setSender_area(String sender_area) {
        this.sender_area = sender_area;
    }

    public String getSender_address() {
        return sender_address;
    }

    public void setSender_address(String sender_address) {
        this.sender_address = sender_address;
    }

    public String getSender_phone() {
        return sender_phone;
    }

    public void setSender_phone(String sender_phone) {
        this.sender_phone = sender_phone;
    }

    public int getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiver_province() {
        return receiver_province;
    }

    public void setReceiver_province(String receiver_province) {
        this.receiver_province = receiver_province;
    }

    public String getReceiver_city() {
        return receiver_city;
    }

    public void setReceiver_city(String receiver_city) {
        this.receiver_city = receiver_city;
    }

    public String getReceiver_area() {
        return receiver_area;
    }

    public void setReceiver_area(String receiver_area) {
        this.receiver_area = receiver_area;
    }

    public String getReceiver_address() {
        return receiver_address;
    }

    public void setReceiver_address(String receiver_address) {
        this.receiver_address = receiver_address;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getDeliver_id() {
        return deliver_id;
    }

    public void setDeliver_id(int deliver_id) {
        this.deliver_id = deliver_id;
    }

    public String getInitial_time() {
        return initial_time;
    }

    public void setInitial_time(String initial_time) {
        this.initial_time = initial_time;
    }

    public String getLive_time() {
        return live_time;
    }

    public void setLive_time(String live_time) {
        this.live_time = live_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTrans_info() {
        return trans_info;
    }

    public void setTrans_info(String trans_info) {
        this.trans_info = trans_info;
    }
}
