package com.ericxxt.logistics_system.service;

import com.ericxxt.logistics_system.entity.Order;

import java.util.List;

public interface OrderService {
    public int insertOrder(Order order);
    public Order selectOrder(int order_id);
    public int deleteOrder(int order_id);
    public List<Order> user_Orders(int user_id);
    public List<Order> manager_Orders(int manager_id);
    public List<Order> deliver_Orders(int deliver_id);
    public int updateOrder(Order order);
    public void update_news(int manager_id);
    public List<Order> unview_Orders();
}
