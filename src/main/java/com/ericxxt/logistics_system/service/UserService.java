package com.ericxxt.logistics_system.service;

import com.ericxxt.logistics_system.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService{
    public User selectAllUsers();
    public User login_verify(String username,String password);
    public int insertUser(User user);
    public List<String> show_provinces();
    public List<String> show_cities(String province);
    public List<String> show_areas(String city);
}
