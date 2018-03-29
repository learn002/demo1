package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.redis.UserRedis;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by newtranx_011 on 2018/3/28.
 */
@RestController
@RequestMapping("/redis")
public class UserControllerTestRedis {

    @Autowired
    private UserRedis userRedis;

    @RequestMapping("")
    public String get() {
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
        userRedis.delete(this.getClass().getName()+":userBynaem:user"+user.getName());
        userRedis.add(this.getClass().getName()+":userBynaem:user"+user.getName(), 10L, user);

        Gson gson = new Gson();
        User user1 = userRedis.get(this.getClass().getName()+":userBynaem:user"+user.getName());
        String songUser = gson.toJson(user1);
        return songUser;
    }
}
