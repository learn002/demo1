package com.example.demo.dao;

import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by newtranx_011 on 2018/3/28.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
