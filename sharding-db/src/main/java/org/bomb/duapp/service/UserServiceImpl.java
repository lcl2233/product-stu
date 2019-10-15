package org.bomb.duapp.service;

import org.bomb.duapp.entity.User;
import org.bomb.duapp.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public User info(Long id) {
        return userMapper.info(id);
    }

    @Override
    public List<User> getUsers(User user) {
        return userMapper.getUsers(user);
    }

    @Override
    public User addUser(User user) {
        LOGGER.info("addUser，{}", user.toString());
        userMapper.addUser(user);
        return user;
    }
}
