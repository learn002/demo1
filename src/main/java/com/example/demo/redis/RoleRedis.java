package com.example.demo.redis;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by newtranx_011 on 2018/3/28.
 */
@Repository
public class RoleRedis {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void add(String key, Long time, Role role) {
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key, gson.toJson(role), time, TimeUnit.MINUTES);
    }

    public void add(String key, Long time, List<Role> roles) {
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key, gson.toJson(roles), time, TimeUnit.MINUTES);
    }

    public Role get(String key) {
        Gson gson = new Gson();
        Role role = null;
        String roleJson = redisTemplate.opsForValue().get(key);
        if(!StringUtils.isEmpty(roleJson))
            role = gson.fromJson(roleJson, Role.class);
        return role;
    }

    public List<Role> getList(String key) {
        Gson gson = new Gson();
        List<Role> roles = null;
        String listJson = redisTemplate.opsForValue().get(key);
        if(!StringUtils.isEmpty(listJson))
            roles = gson.fromJson(listJson, new TypeToken<List<Role>>(){}.getType());
        return roles;
    }

    public void delete(String key) {
        redisTemplate.opsForValue().getOperations().delete(key);
    }

}
