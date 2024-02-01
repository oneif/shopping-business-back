package com.business.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//统一响应结果(分页)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageResult<T> {
    private Integer code;//业务状态码  成功-200  失败-1
    private String message;//提示信息
    private T data;//响应数据
    private Long current;// 当前页码
    private Long size;// 每页条数
    private Long total;// 总数
    private Long pages;// 总页数

    //快速返回操作成功响应结果(带响应数据)
    public static <E> PageResult<E> success(String message, E data, Long current, Long size, Long total, Long pages) {
        return new PageResult<>(200, message, data, current, size, total, pages);
    }

    //失败
//    public static PageResult success(String message, String data, Integer current, Integer size, Integer total, Integer pages) {
//        return new PageResult<>(200, message, data, current, size, total, pages);
//    }
}
