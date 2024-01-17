package com.business.service;

import com.business.pojo.BusinessUser;

public interface BusinessUserService {
    // 根据用户名查询用户
    BusinessUser findByUserName(String username);

    // 注册用户名方法
    void register(String username, String password);

    // 注册商户
    void registerBusiness(BusinessUser businessUser);

    // 根据id查审核状态
    String selectStatusById(Long id);
}
