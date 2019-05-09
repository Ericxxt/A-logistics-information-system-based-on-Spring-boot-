package com.ericxxt.logistics_system.dao;


import com.ericxxt.logistics_system.entity.User;

import java.util.List;

public interface UserDao {
    public User selectAllUsers();
    public User login_verify(String username,String password);
    public int insertUser(User user);
    public List<String> show_province();
    public List<String> show_cities(String province);
    public List<String> show_areas(String city);
}
