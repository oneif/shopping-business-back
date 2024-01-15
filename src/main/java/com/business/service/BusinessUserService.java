package com.business.service;

import com.business.pojo.BusinessUser;

public interface BusinessUserService {
    // 根据用户名查询用户
    BusinessUser findByUserName(String username);

    // 注册方法
    void register(String username, String password);
}
