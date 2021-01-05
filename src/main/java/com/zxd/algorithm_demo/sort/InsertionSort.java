package com.zxd.algorithm_demo.sort;

import java.util.Arrays;

/**
 * Created by Zxd on 2021/1/5 11:08
 */
//插入排序
public class InsertionSort {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (greater(a[j - 1], a[j]))
                    exchange(a,j-1,j);
                else
                    break;//最好情况，和前一个比，发现比前面数大，因为前面已经排好序，可直接退出本次循环 O(n)
            }
        }
    }

    public static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }
    public static void exchange(Comparable[] a,int i,int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 3, 4, 8, 7, 5};
        InsertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
