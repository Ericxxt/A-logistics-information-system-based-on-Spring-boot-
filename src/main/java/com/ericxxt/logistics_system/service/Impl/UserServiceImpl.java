package com.ericxxt.logistics_system.service.Impl;

import com.ericxxt.logistics_system.dao.UserDao;
import com.ericxxt.logistics_system.entity.User;
import com.ericxxt.logistics_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User selectAllUsers() {
        return this.userDao.selectAllUsers();
    }
    @Override
    public User login_verify(String username,String password){
        return this.userDao.login_verify(username,password);
    }

    @Override
    public int insertUser(User user) {
        return this.userDao.insertUser(user);
    }

    @Override
    public List<String> show_provinces() {
        return this.userDao.show_province();
    }

    @Override
    public List<String> show_cities(String province) {
        return this.userDao.show_cities(province);
    }

    @Override
    public List<String> show_areas(String city) {
        return this.userDao.show_areas(city);
    }
}
