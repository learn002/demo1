package com.example.demo.entity;

import javax.persistence.*;

/**
 * Created by newtranx_011 on 2018/3/28.
 */

@Entity
@Table(name = "deparment")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
