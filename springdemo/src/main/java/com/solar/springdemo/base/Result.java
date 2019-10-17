package com.solar.springdemo.base;


import lombok.Getter;
import lombok.Setter;

/**
 * @author huangzhibo
 * @date 2019-08-26
 */
@Getter
@Setter
public class Result<T> {

    private Integer code;

    private String errorCode = "";

    private String msg;

    private T data;

    public Result(){}

    public Result(T body){
        super();
        this.data = body;
    }
}
