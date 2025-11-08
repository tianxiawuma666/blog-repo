package com.xxx.user.mapper;

import com.xxx.user.domain.User;
import com.xxx.user.query.UserQuery;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
    User findOne(Long id);
    List<User> queryPage(UserQuery userQuery);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    void batchUsers(Long[] ids);
}
