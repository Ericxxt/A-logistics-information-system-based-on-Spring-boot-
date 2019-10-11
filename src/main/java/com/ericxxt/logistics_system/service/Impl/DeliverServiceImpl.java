package com.ericxxt.logistics_system.service.Impl;

import com.ericxxt.logistics_system.dao.DeliverDao;
import com.ericxxt.logistics_system.entity.Deliver;
import com.ericxxt.logistics_system.service.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliverServiceImpl implements DeliverService {
    @Autowired
    private DeliverDao deliverDao;
    @Override
    public void update_order(int order_id,String status, String volume, String trans_info) {
            this.deliverDao.update_order(order_id,status,volume,trans_info);
    }

    @Override
    public void finish_time(int order_id, String live_time) {
        this.deliverDao.finish_time(order_id,live_time);
    }
    public Deliver login_verify(String deliver_name, String password) {
        return this.deliverDao.login_verify(deliver_name,password);
    }

    @Override
    public void update_Salary(int diliver_id, String salary) {
         this.deliverDao.update_Salary(diliver_id, salary);
    }
}
