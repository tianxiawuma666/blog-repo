package com.xxx.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxx.user.domain.User;
import com.xxx.user.mapper.UserMapper;
import com.xxx.user.query.UserQuery;
import com.xxx.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userMapper.findOne(id);
    }

    @Override
    public List<User> queryPage(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getCurrentPage(), userQuery.getPageSize());

        return userMapper.queryPage(userQuery);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    //alt shif p
    @Override
    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }

    @Override
    public void batchUsers(Long[] ids) {
        userMapper.batchUsers(ids);
    }
}
