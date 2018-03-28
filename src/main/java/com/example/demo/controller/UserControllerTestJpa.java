package com.example.demo.controller;

import com.example.demo.Dao.DepartmentRepository;
import com.example.demo.Dao.RoleRepository;
import com.example.demo.Dao.UserRepository;
import com.example.demo.entity.Department;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by newtranx_011 on 2018/3/28.
 * jpa 测试类
 */
@RestController()
@RequestMapping("jpa")
public class UserControllerTestJpa {

    private final Logger logger = LoggerFactory.getLogger(UserControllerTestJpa.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping("")
    public String get() {
        //部门
        Department department = new Department();
        department.setName("开发部");
        departmentRepository.save(department);
        System.out.println("==="+department.getId());
        //角色
        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        System.out.println("==="+role.getId());
        //用户
        User user = new User();
        user.setName("user");
        user.setCreatedate(new Date());
        user.setDeparment(department);
        List<Role> roles = roleRepository.findAll();
        user.setRoles(roles);
        userRepository.save(user);
        System.out.println("==="+user.getId());

        //全部结果
        Pageable pageable = new PageRequest(0, 10, new Sort(Sort.Direction.ASC, "id"));
        Page<User> page = userRepository.findAll(pageable);
        for (User user1: page.getContent()) {
            logger.info("user name:{}, department name:{}, role name:{}",
                    user1.getName(),
                    user1.getDeparment().getName(),
                    user1.getRoles().get(0).getName());
        }


        return "user2";
    }
}
