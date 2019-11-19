package org.bomb.duapp.user.api;

import org.bomb.duapp.user.dto.UserDto;

public interface UserAPI {
    String login(String username,String password);

    UserDto getByUserId(String userId);
}
