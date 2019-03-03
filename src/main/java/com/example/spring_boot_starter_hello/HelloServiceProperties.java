package com.example.spring_boot_starter_hello;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: aimiguo
 * @Date: 2018/10/9
 * @Time: 14:56
 * Description:属性配置
 */
//类型安全的属性配置
@PropertySource({"classpath:/my.properties"})//注意路径的书写格式
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {

    private static final String MSG="world";

    private String msg=MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
