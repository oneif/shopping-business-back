package com.business.service.impl;

import com.business.mapper.BusinessUserMapper;
import com.business.pojo.BusinessUser;
import com.business.service.BusinessUserService;
import com.business.utils.Md5Util;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessUserServiceImpl implements BusinessUserService {

    @Autowired
    private BusinessUserMapper businessUserMapper;

    @Override
    public BusinessUser findByUserName(String username) {
        QueryWrapper<BusinessUser> qw = new QueryWrapper<>();
        return businessUserMapper.selectOne(qw.eq("username",username));
    }

    @Override
    public void register(String username, String password) {
        String md5String = Md5Util.getMD5String(password);
        BusinessUser businessUser = new BusinessUser();
        businessUser.setUsername(username);
        businessUser.setPassword(md5String);
        businessUserMapper.insert(businessUser);
    }

    @Override
    public void registerBusiness(BusinessUser businessUser) {
        businessUserMapper.updateById(businessUser);
    }

    @Override
    public String selectStatusById(Long id) {
        QueryWrapper<BusinessUser> qw = new QueryWrapper<>();
        return businessUserMapper.selectOne(qw.eq("id",id)).getStatus();
    }
}

