package org.bomb.duapp.sharding.mapper;

import org.bomb.duapp.sharding.entity.User;

import java.util.List;

public interface UserMapper {

    User info(Long id);

    List<User> getUsers(User user);

    void addUser(User user);
}
