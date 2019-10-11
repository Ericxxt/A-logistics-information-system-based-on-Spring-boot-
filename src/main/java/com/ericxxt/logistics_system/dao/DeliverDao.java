package com.ericxxt.logistics_system.dao;

import com.ericxxt.logistics_system.entity.Deliver;

public interface DeliverDao {
    public void update_order(int order_id,String status,String volume,String trans_info);
    public void finish_time(int order_id,String live_time);
    public Deliver login_verify(String deliver_name, String password);
    public void update_Salary(int diliver_id,String salary);
}
