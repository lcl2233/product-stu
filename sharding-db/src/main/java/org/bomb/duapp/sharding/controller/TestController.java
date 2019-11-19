package org.bomb.duapp.sharding.controller;

import org.bomb.duapp.sharding.common.JdbcTemplate;
import org.bomb.duapp.sharding.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/sharding/test")
    public User test(){
        User user = new User();
        user.setId(1L);
        user.setUsername("bomb");
        user.setPassword("123456");
        user.setNickName("bomb");
        user.setSex(1);
        user.setCreateTime(1570869577L);
        user.setUpdateTime(1570869577L);
        return user;
    }

    @GetMapping("/jdbc/user/{id}")
    public String infoByJdbc(@PathVariable("id") Long id) {
        String sql = "select * from user where id = " + id;
        return new JdbcTemplate(sql).executionQuery();
    }

}
