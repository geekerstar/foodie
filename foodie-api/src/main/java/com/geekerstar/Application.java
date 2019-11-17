package com.geekerstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author geekerstar
 * date: 2019/11/16 20:18
 * description:
 */
@SpringBootApplication
@MapperScan(basePackages = "com.geekerstar.mapper")
@ComponentScan(basePackages = {"com.geekerstar","org.n3r.idworker"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

