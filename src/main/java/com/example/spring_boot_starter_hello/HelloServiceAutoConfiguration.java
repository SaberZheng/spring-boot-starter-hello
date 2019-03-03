package com.example.spring_boot_starter_hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: aimiguo
 * @Date: 2018/10/9
 * @Time: 15:03
 * Description:自动配置类
 */
//@Configuration标注在类上，相当于把该类作为spring的xml配置文件中的<beans>，作用为：配置spring容器(应用上下文)
@Configuration
//开启属性输入
@EnableConfigurationProperties(HelloServiceProperties.class)
//判断HelloService这个类在类路径中是否存在，且在没有这个bean的情况下会自动配置这个bean
@ConditionalOnClass(HelloService.class)
//当设置hello=enable的情况下，如果没有设置默认为true，即条件符合
@ConditionalOnProperty(prefix = "hello",value = "enabled",matchIfMissing = true)
public class HelloServiceAutoConfiguration {
    @Autowired
    private HelloServiceProperties helloServiceProperties;
    //使用Java配置的方式配置bean
    @Bean
    //当容器没有这个bean的时候会新建bean
    @ConditionalOnMissingBean(HelloService.class)
    public  HelloService helloService(){
        HelloService helloService = new HelloService();
        helloService.setMsg(helloServiceProperties.getMsg());
        return helloService;
    }
}
