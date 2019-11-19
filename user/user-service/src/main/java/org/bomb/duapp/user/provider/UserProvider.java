package org.bomb.duapp.user.provider;

import org.bomb.duapp.user.api.UserAPI;
import org.bomb.duapp.user.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserProvider implements UserAPI {

    @Override
    public String login(String username, String password) {
        if ("bomb".equals(username) && "123456".equals(password)) return "login success";
        return "login fail";
    }

    @Override
    public UserDto getByUserId(String userId) {
        UserDto userDto = new UserDto();
        userDto.setId(1L);
        userDto.setUserId(userId);
        userDto.setNickname("bomb");
        userDto.setUsername("lcl");
        userDto.setImgUrl("xxx");
        return userDto;
    }
}
