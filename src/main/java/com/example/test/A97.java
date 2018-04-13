package com.example.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by newtranx_011 on 2018/4/11.
 */
public class A97 {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    public static void test3() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.toJSONString();
    }

    public static void test2() {
        int z = 400;
        int a = 10 & z;
        System.out.println(a);
        int b = 10 % z;
        System.out.println(b);
        LongAdder longAdder = new LongAdder();
        longAdder.add(1);
        longAdder.add(1);
        System.out.println(longAdder);
        System.out.println(longAdder.intValue());
        System.out.println(longAdder.doubleValue());
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.getAndAdd(1);
//        AtomicLong
//LongAdder
//        ReentrantLock
//        Semaphore
//        CountDownLatch
//        ReentrantReadWriteLock.

    }


    public static void test1() {
//        LongAdder
//        ConcurrentHashMap
//        LongAdder
    }
}
