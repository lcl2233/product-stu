package org.bomb.duapp.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@MapperScan("org.bomb.duapp.mp.infrastructure.integration.db.mapper")
public class MpApplication {

    public static void main(String[]args) {
        SpringApplication.run(MpApplication.class, args);
    }
}
