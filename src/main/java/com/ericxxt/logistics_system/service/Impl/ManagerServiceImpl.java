package com.ericxxt.logistics_system.service.Impl;

import com.ericxxt.logistics_system.dao.ManagerDao;
import com.ericxxt.logistics_system.entity.Deliver;
import com.ericxxt.logistics_system.entity.Manager;
import com.ericxxt.logistics_system.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;

    @Override
    public List<Deliver> select_delivers() {
        return this.managerDao.select_delivers();
    }

    @Override
    public List<Deliver> local_delivers(String province) {
        return this.managerDao.local_delivers(province);
    }

    @Override
    public void update_order(int order_id,int manager_id, int deliver_id, String status, String trans_info) {
        this.managerDao.update_order(order_id,manager_id,deliver_id,status,trans_info);
    }

    @Override
    public Manager login_verify(String username, String password) {
        return this.managerDao.login_verify(username,password);
    }

    @Override
    public void update_news(int deliver_id) {
        this.managerDao.update_news(deliver_id);
    }

    @Override
    public List<String> deliver_provinces() {
        return this.managerDao.deliver_provinces();
    }

    @Override
    public List<Deliver> select_order_delivers(String province) {
        return this.managerDao.select_order_delivers(province);
    }
}
