package com.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by newtranx_011 on 2018/4/4.
 */
public class TestSort {
    public static void main(String[] args) {
        int[] a = {4, 2, 3, 1};
//        bubbleSort(a, 0, 3);
//        insertionSort(a, 0, 3);
//        quickSort(a, 0, 3);
        sampleSort(a, 0, 3);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
//        Collections.sort();

        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.addAll(Arrays.asList());


    }

    //简单排序
    public static void sampleSort(int[] a, int left, int right) {
        for (int i = 0; i < a.length; i++) {
            int max = i;
            for (int j = i + 1; j < a.length; j++) {
                if(a[i] > a[j]) {
                    max = j;
                }
            }
            int temp = a[max];
            a[max] = a[i];
            a[i] = temp;
        }
    }

    //快速排序算法
    public static void quickSort(int[] a, int left, int right) {
        int i = left,
            j = right,
            key = a[left];
        while (i < j) {
            while (i < j && a[i] <= a[j]) {
                j--;
            }
            if(i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] >= a[j]) {
                i++;
            }
            if(i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = key;
        if(i > left) quickSort(a, left, i - 1);
        if(j < right) quickSort(a, j + 1, right);

    }

    //插入排序
    public static void insertionSort(int[] a, int left, int right) {
        int  len = right - left + 1;
        for (int i = left, j = i; i < len - 1; j = ++i) {
            int ai = a[i + 1];
            while (ai < a[j]) {
                a[j + 1] = a[j];
                if(j-- == left) {
                    break;
                }
            }
            a[j + 1] = ai;
        }
    }
    //冒泡
    public static void bubbleSort (int[] a, int left, int right) {
        for (int i = 0; i< a.length; i++) {
            for (int j = 0; j < (a.length - i -1); j++) {
                if(a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}
