package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by newtranx_011 on 2018/3/28.
 * 这个jpa的扩展，可以自定义sql，但是不知道动态sql。 例如：条件查询的时候
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
//    @Query("select t from User t where t.naem=?1 and t.email=?2")
//    User findBYNameAdnEmail(String name, String email);
//
//    @Query("select  t from User t where t.naem like :name")
//    Page<User> findByName(@Param("name") String name, Pageable pageRequest);
}
