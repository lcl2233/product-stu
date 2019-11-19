package org.bomb.duapp.user.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.bomb.duapp.user.api.UserAPI;
import org.bomb.duapp.user.dto.UserDto;
import org.bomb.duapp.user.sentinel.block.UserBlockHandler;
import org.bomb.duapp.user.sentinel.fallback.UserFallBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
@RestController
public class UserService {

    @Autowired
    UserAPI userAPI;

    @SentinelResource(value="login",
            blockHandlerClass = UserBlockHandler.class, blockHandler = "login",
            fallbackClass = UserFallBack.class, fallback = "login"
    )
    @GetMapping("/user/login/{username}/{password}")
    public String login(@PathVariable("username") String username, @PathVariable("password") String password) {
        return userAPI.login(username, password);
    }

    @GetMapping("/user/{userId}")
    public UserDto getByUserId(@PathVariable("userId") String userId) {
        return userAPI.getByUserId(userId);
    }

    @PostMapping("/users")
    public List<UserDto> query(UserDto userDto) {
        List<UserDto> result = new ArrayList<>();
        result.add(userDto);
        return result;
    }

}
