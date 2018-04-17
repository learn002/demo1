package com.example.test;

import javafx.scene.input.DataFormat;
import sun.text.resources.FormatData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by newtranx_011 on 2018/4/16.
 */
public class A96 {
    public static void main(String[] args) {
//        test1();
        test2();
        test3();
    }

    public static void test3() {
        LinkedList l = new LinkedList();
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MMM.dd G hh:mm a");
        System.out.println(simpleDateFormat.format(new Date()));
        System.out.println(DateFormat.getInstance().format(new Date()));
    }
    public static void test2() {
        int count = 0;
        for (int i = 101; i < 200; i = i + 2) {
            boolean b = false;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i%j == 0) {
                    b = false;
                    break;
                } else {
                    b = true;
                }
            }
            if(b == true) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static void test1() {
//        1 1 2 3 5
        int f1 = 1;
        int f2 = 1;
        int M = 24;
        System.out.println("1:" + 1);
        System.out.println("2:" + 1);
        for(int i = 3; i < M; i++) {
            f2 = f1 + f2;
            f1 = f2 - f1;
            System.out.println(f2);
        }

    }
}
