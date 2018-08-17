package com.example.service;

import com.example.pojo.User;

/**
 * Created by WangZJ on 2018/8/13.
 */
public interface UserService {
    String getPasswordByUserName(String username);
    
    User findUserByName(String name);
}
