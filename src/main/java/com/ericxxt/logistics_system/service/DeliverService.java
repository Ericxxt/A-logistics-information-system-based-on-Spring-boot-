package com.ericxxt.logistics_system.service;

import com.ericxxt.logistics_system.entity.Deliver;

public interface DeliverService {
    public void update_order(int order_id,String status,String volume,String trans_info);
    public void finish_time(int order_id,String live_time);
    public Deliver login_verify(String deliver_name, String password);
}
