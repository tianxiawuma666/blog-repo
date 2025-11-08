package com.xxx.user.controller;

import com.github.pagehelper.PageInfo;
import com.xxx.base.utils.R;
import com.xxx.user.domain.User;
import com.xxx.user.query.UserQuery;
import com.xxx.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//@rc
@RequestMapping("/user")
@Api(tags = "用户接口类")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
    @ApiOperation(value = "查询所有")
    public R<List<User>> findAll() {
        List<User> users = userService.findAll();
        System.out.println(users);
        return R.ok(users);//alt enter生成返回值
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询单个")
    public R<User> findOne(@PathVariable Long id) {
        User user = userService.findOne(id);
        return R.ok(user);//alt enter生成返回值
    }

    @PostMapping
    @ApiOperation(value = "分页+条件查询")
    public PageInfo<User> queryPage(@RequestBody UserQuery userQuery) {
        List<User> list = userService.queryPage(userQuery);
        return new PageInfo<User>(list);//alt enter生成返回值,list分页集合
    }

    @PutMapping
    @ApiOperation(value = "增加or修改")
    public R<Void> addOrUpdate(@RequestBody User user) {
        //try
        try {
            Long id = user.getId();

            if (id==null){
                userService.addUser(user);
            }else {
                userService.updateUser(user);
            }
        } catch(Exception e) {
            e.printStackTrace();
            return R.fail();
        }

        return R.ok();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除单个")
    public R<Void> deleteUser(@PathVariable Long id) {
        //try
        try {
            userService.deleteUser(id);
        } catch(Exception e) {
            e.printStackTrace();
            return R.fail();
        }

        return R.ok();
    }

    @PatchMapping
    @ApiOperation(value = "批量删除")
    public R<Void> batchUsers(@RequestBody Long[] ids) {
        try {
            userService.batchUsers(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return R.fail();
        }

        return R.ok();
    }
}
