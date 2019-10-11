package com.ericxxt.logistics_system.service;

import com.ericxxt.logistics_system.entity.Deliver;
import com.ericxxt.logistics_system.entity.Manager;

import java.util.List;

public interface ManagerService {
    public List<Deliver> select_delivers();
    public List<Deliver> local_delivers(String province);
    public void update_order(int order_id,int manager_id,int deliver_id,String status,String trans_info);
    public Manager login_verify(String username, String password);
    public void update_news(int deliver_id);
    public List<String> deliver_provinces();
    public List<Deliver> select_order_delivers(String province);
    public void update_Salary(int manager_id,String salary);
    public String return_salary(int manager_id);
}
