package org.bomb.duapp.user.feign;

import org.bomb.duapp.user.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user")
public interface UserClient {

    @GetMapping("/user/{userId}")
    UserDto getByUserId(@PathVariable("userId") String userId);

}
