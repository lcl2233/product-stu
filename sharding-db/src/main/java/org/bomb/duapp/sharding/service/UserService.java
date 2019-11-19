package org.bomb.duapp.sharding.service;

import org.bomb.duapp.sharding.entity.User;

import java.util.List;

public interface UserService {
    User info(Long id);

    List<User> getUsers(User user);

    User addUser(User user);
}
