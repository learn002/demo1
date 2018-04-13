package com.example.test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by newtranx_011 on 2018/4/8.
 */


public class A99 {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        System.out.println(test5());
//        test6();
//        test7();
        test8();
    }

    public static void test8() {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.set(3);
//        ConcurrentLinkedQueue
//        ThreadLocal
//        Unsafe unsafe = Unsafe.getUnsafe();
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe)f.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(atomicInteger);

    }

    public static void test7() {
//        ThreadPoolExecutor
//        ExecutorService executor = Executors.newFixedThreadPool(5);
//        Future<String> future = executor.submit();
//        future.isDone();
//        future.get()

    }
    public static void test6() {

//        ConcurrentHashMap
//        Hashtable
        AtomicInteger atomicInteger = new AtomicInteger(2);
        System.out.println(atomicInteger);
        AtomicReference<String> stringAtomicReference = new AtomicReference<>();

//        Lock lock = new Lock
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
//        condition.
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        String s = "test";
        Thread thread = new Thread(() -> {
            System.out.println(s + Thread.currentThread().getName());
//            Thread.sleep();

        });
        thread.start();
//        Thread.sleep();
        synchronizedList.listIterator();
        synchronizedList.iterator();
//        ConcurrentLinkedQueue
//        Semaphore
//        Condition
    }


    public static String test5() {

        return
        "test";

    }
    public static void test4() {
        WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
//        weakHashMap.put();
        System.out.println(1 << 30);
    }

    public static void test3() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put(null, "test");
        ArrayList arrayList;
        Vector vector;
        LinkedList linkedList;
        LinkedHashMap linkedHashMap;
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "b");
        map.put(null, "test");
        map.put(null, "test");
        map.put("", "test");
        map.entrySet().stream().forEach(s -> System.out.println(s.getKey() + " | " + s.getValue()));


        List<String> list = new ArrayList<>();
        list.stream().forEach(s -> System.out.println(s));
//        map = Collections.synchronizedMap(map);
//        map.put("a", "b");
    }

    public static void test2() {
        Person person = new Person();
        Person person1 = person;
        System.out.println(person.equals(person1));
        StringBuilder stringBuilder;
        StringBuffer stringBuffer;
    }

    public static void test1() {
        String s = "hello";
        String t = "hello";
        char[] c = {'a', 'b'};
        char[] c1 = {'a', 'b'};
        System.out.println(s==t);
        System.out.println(c==c1);
        System.out.println(c.equals(c1));
        LocalDate birthday;
        HashSet<String> set = new HashSet<>();
        set.add("a");
        set.add("a");
        set.add(null);
        set.stream().forEach(System.out::println);
    }
}
