package com.business.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//统一响应结果
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code;//业务状态码  成功-200  失败-1
    private String message;//提示信息
    private T data;//响应数据

    //快速返回操作成功响应结果(带响应数据)
    public static <E> Result<E> success(String message, E data) {
        return new Result<>(200, message, data);
    }

    //快速返回操作成功响应结果
    public static Result success(String message) {
        return new Result(200, message, null);
    }

    //失败
    public static Result error(String message) {
        return new Result(-1, message, null);
    }

    //自定义
    public static Result others(Integer code, String message) {
        return new Result(code, message, null);
    }
}
