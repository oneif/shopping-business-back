package com.business.pojo;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import java.time.LocalDateTime;

@Data
// lombok 在编译阶段 为实体类自动添加getter setter toString方法
// pom 文件中引入依赖 在实体类上添加注解
public class BusinessUser {
    private Long id;//主键ID
    private String username;//用户名
    private String password;//密码
    private String telephone;//手机号
    private String email;//邮箱
    private String userPic;//用户头像地址
    private String introduction;//商家介绍
    private String status;//审核状态
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;//创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;//更新时间
}
