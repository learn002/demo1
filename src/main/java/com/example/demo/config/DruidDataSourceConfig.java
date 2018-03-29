//package com.example.demo.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
///**
// * Created by newtranx_011 on 2018/3/28.
// */
//@Configuration
//public class DruidDataSourceConfig {
//
//    @Bean(name="userDataSource")
//    @Primary
//    @ConfigurationProperties(prefix="spring.datasource.user")
//    public DataSource primaryDataSource() {
//        System.out.println("-------------------- userDataSource init ---------------------");
//        return new DruidDataSource();
//    }
//}
