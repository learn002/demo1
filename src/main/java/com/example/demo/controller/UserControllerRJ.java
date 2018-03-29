package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by newtranx_011 on 2018/3/29.
 */
@RestController
@RequestMapping("user")
public class UserControllerRJ {

    @Autowired
    private UserService2 userService2;

    private static Long tempId = 7L;

    @RequestMapping(value = "get")
    public User get() {
        return userService2.findById(tempId);
    }

    @RequestMapping(value = "create")
    public User create() {
        User user = new User();
        user.setCreatedate(new Date());
        user.setName("test name");
        user = userService2.create(user);
        tempId = user.getId();
        return user;
    }

    @RequestMapping(value = "update")
    public User update() {
        User user = userService2.findById(tempId);
        user.setName("test name update");
        return userService2.update(user);
    }

    @RequestMapping(value = "delete")
    public void delete() {
        userService2.delete(tempId);
    }

    @RequestMapping(value = "init")
    public User init() {
        Department department = new Department();
        department.setName("开发部");

        Role role = new Role();
        role.setName("admin");

        User user = new User();
        user.setName("user");
        user.setCreatedate(new Date());
        user.setDeparment(department);

        List<Role> roles = new ArrayList<>();
        roles.add(role);

        user.setRoles(roles);
//        userRedis.delete(this.getClass().getName()+":userBynaem:user"+user.getName());
//        userRedis.add(this.getClass().getName()+":userBynaem:user"+user.getName(), 10L, user);
//
//        Gson gson = new Gson();
//        User user1 = userRedis.get(this.getClass().getName()+":userBynaem:user"+user.getName());
//        String songUser = gson.toJson(user1);
//        return songUser;
//        return userService2.findById(id);
        return null;
    }


}
