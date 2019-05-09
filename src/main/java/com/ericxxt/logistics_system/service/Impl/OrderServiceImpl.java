package com.ericxxt.logistics_system.service.Impl;

import com.ericxxt.logistics_system.dao.OrderDao;
import com.ericxxt.logistics_system.entity.Order;
import com.ericxxt.logistics_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public int insertOrder(Order order) {
        return this.orderDao.insertOrder(order);
    }

    @Override
    public Order selectOrder(int order_id) {
        return this.orderDao.selectOrder(order_id);
    }

    @Override
    public int deleteOrder(int order_id) {
        return this.orderDao.deleteOrder(order_id);
    }

    @Override
    public List<Order> user_Orders(int user_id) {
        return this.orderDao.user_Orders(user_id);
    }

    @Override
    public List<Order> manager_Orders(int manager_id) {
        return this.orderDao.manager_Orders(manager_id);
    }

    @Override
    public List<Order> deliver_Orders(int deliver_id) {
        return this.orderDao.deliver_Orders(deliver_id);
    }
    @Override
    public int updateOrder(Order order) {
        return this.orderDao.updateOrder(order);
    }

    @Override
    public void update_news(int manager_id) {
        this.orderDao.update_news(manager_id);
    }

    @Override
    public List<Order> unview_Orders() {
        return this.orderDao.unview_Orders();
    }
}
