package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.redis.UserRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by newtranx_011 on 2018/3/29.
 */
@Service
public class UserService2 {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRedis userRedis;
    private static final String keyHead = "mysql:get:user";
    private static final Long longTime = 30L;

    public User findById(Long id) {
        User user = userRedis.get(keyHead + id);
        if(null == user) {
            return userRepository.findOne(idToExample(id)).orElse(null);
        }
        return user;
    }

    public User create(User user) {
        User newUser = userRepository.save(user);
        if(newUser != null) {
            userRedis.add(keyHead + newUser.getId(), longTime, newUser);
        }
        return newUser;
    }

    public User update(User user) {
        if(user != null) {
            userRedis.delete(keyHead + user.getId());
            userRedis.add(keyHead + user.getId(), longTime, user);
        }
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRedis.delete(keyHead + id);
        User user = new User();
        user.setId(id);
        userRepository.delete(user);
    }

    public Example<User> idToExample(Long id) {
        User user = new User();
        user.setId(id);
        Example<User> example = Example.of(user);
        return example;
    }
}
