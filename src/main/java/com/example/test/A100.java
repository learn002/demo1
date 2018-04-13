package com.example.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by newtranx_011 on 2018/3/28.
 */
public class A100 {
    public static void main(String[] args) {

        test1();

    }

    public static void test1() {
//        Collections.sort();
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
//        AtomicStampedReference
//        AtomicReference
//        ReentrantLock
//        returnAddress
        int[] a = {10, 8, 9, 4, 6, 5, 7, 3, 1, 2};
        String[] strings = {"z", "y", "b", "a"};
//        quickSort(a, 0, a.length-1);
        insertionSort3(a, 0, 9);
//        quick_sort(a, 0, 9);
        for (int i=0; i < a.length; i++) {
            System.out.println(a[i]);
        }
//        Arrays.sort();
//         Arrays.asList(a).forEach(v -> System.out.println(v));
    }

    public static void insertionSort3(int[] a, int left, int right) {
        for(int i = left, j = i; i < right; j = ++i) {
            int ai = a[i + 1];
            while(ai > a[j] ) {
                a[j + 1] = a[j];
                if(j-- == left) {
                    break;
                }
            }
            a[j + 1] = ai;
        }
    }



    //插入排序
    public static void insertionSort2(int[] a, int left, int right) {
        for(int i = left, j = i; i < right; j = ++i) {
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









    //插入排序
    public static void insertionSort1(int[] a, int start, int end) {
//        int len = end - start + 1;
        for (int i = start, j = i; i < end; j = ++i) {
            int ai = a[i + 1];
            while (ai < a[j]) {
                a[j + 1] = a[j];
                if (j-- == start) {
                    break;
                }
            }
            a[j + 1] = ai;
        }
    }

    /**
     *插入排序
     *@paramarr
     *@return
     */
    private static int[] insertSort(int[]arr){
        if(arr == null || arr.length < 2){
            return arr;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
//TODO:
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }else{
//接下来是无用功
                    break;
                }
            }
        }
        return arr;
    }



    public static void insertionSort(int[] a, int left, int right) {
        int length = right - left + 1;
        for(int i = left, j = i; i < length; j = ++i) {
            int ai = a[i];
            while (ai < a[j]) {
                a[j + 1] = a[j];
                if(j++ == right) {
                    break;
                }
            }
            a[j] = ai;
        }
    }
    /**
     * 1.先比较右边比基准值大的
     * 2.再比较左边比基准值大的
     * 3.如果ij
     */
    //10 , 9  8 7 6 5 4 3 2 1
    public  static void quickSort2(int[] a, int left, int right) {
        int i = left,
            j = right,
            key = a[left];
        while (i < j) {
            while (i < j && a[i] < a[j]) {
                j--;
            }
            if(i < j) {
                a[j] = key;
                i++;
            }
            while (i < j && a[i] > a[j]) {
                i++;
            }
            if(i < j) {
                a[j] = a[i];
                j--;
            }
        }
        a[j] = key;

    }





    public static void quickSort(int[] a, int left, int right) {
        int i = left,
            j = right,
            key = a[left];
        while(i < j) {
            while (i < j && a[i] <= a[j]) {
                j--;
            }
            if(i < j) {
                a[i] = a[j];
                i++;
            }

            while (i < j && a[i] >= a[j]) {
                i++;
            }
            if(i < j) {
                a[j] = a[i];
                j--;
            }
        }
        a[i] = key;
        if(i > left) quickSort(a, left, i-1);
        if(j < right) quickSort(a, j+1, right);
    }

    private static void quick_sort(int s[], int l, int r)
    {
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }
}
