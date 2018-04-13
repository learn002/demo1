package com.example.demo.service;

import com.example.demo.dao.RoleRepository;
import com.example.demo.entity.Role;
import com.example.demo.redis.RoleRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by newtranx_011 on 2018/3/29.
 */
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleRedis roleRedis;

    @Cacheable(value = "mysql:findById:role", keyGenerator = "simpleKey")
    public Optional<Role> findById(Long id) {
        Role role = new Role();
        role.setId(id);
        Example<Role> example = Example.of(role);
        return roleRepository.findOne(example);
    }

    @CachePut(value = "mysql:findById:role", keyGenerator = "objectId")
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @CachePut(value = "mysql:findById:role", keyGenerator = "objectId")
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    @Cacheable(value = "mysql:findById:role", keyGenerator = "simpleKey")
    public void delete(Long id) {
        Role role = new Role();
        role.setId(id);
        roleRepository.delete(role);
    }



}
