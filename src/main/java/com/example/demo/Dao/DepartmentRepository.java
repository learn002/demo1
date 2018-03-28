package com.example.demo.Dao;

import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by newtranx_011 on 2018/3/28.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
