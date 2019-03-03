package com.example.spring_boot_starter_hello;

import org.springframework.stereotype.Component;

/**
 * @Author: aimiguo
 * @Date: 2018/10/9
 * @Time: 15:06
 * Description:
 */
public class HelloService {

    private String msg;

    public String sayHello(){
        return "hello "+msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
