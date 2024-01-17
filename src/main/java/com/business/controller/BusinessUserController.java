package com.business.controller;

import com.business.pojo.Result;
import com.business.utils.JwtUtil;
import com.business.utils.Md5Util;
import com.business.pojo.BusinessUser;
import com.business.service.BusinessUserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/business")
@Validated
public class BusinessUserController {

    @Autowired
    private BusinessUserService businessUserService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{4,16}$") String username, @Pattern(regexp = "^\\S{4,16}$") String password) {
        // 查询用户名
        BusinessUser businessUser = businessUserService.findByUserName(username);
        if (businessUser == null) {
            // 注册
            businessUserService.register(username, password);
            return Result.success("注册成功");
        } else {
            return Result.error("用户名已存在");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{4,16}$") String username, @Pattern(regexp = "^\\S{4,16}$") String password) {
        // 查询用户名
        BusinessUser loginUser = businessUserService.findByUserName(username);
        // 判断用户是否存在
        if (loginUser == null) return Result.error("用户名错误");
        // 判断密码是否正确
        if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());
            String token = JwtUtil.getToken(claims);

            return Result.success("登录成功", token);
        }
        return Result.error("密码错误");
    }

    @PostMapping("/update")
    public Result<String> update(BusinessUser businessUser){
        if(businessUser.getId() == null) return Result.error("商户id不能为空");

        String status = businessUserService.selectStatusById(businessUser.getId());
        if(!Objects.equals(status, "CHECKING")){
            // status不等于CHECKING才调方法改状态
            businessUserService.registerBusiness(businessUser);
            return Result.success("信息提交成功，请等待管理员审核");
        }else return Result.error("当前商户已提交审核，不能再修改");
    }
}
