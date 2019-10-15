package org.bomb.duapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"org.bomb.duapp.mapper"})
public class ShardingDBApplication {

    public static void main(String[]args) {
        SpringApplication.run(ShardingDBApplication.class, args);
    }
}
