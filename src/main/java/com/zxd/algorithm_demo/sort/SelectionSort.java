package com.zxd.algorithm_demo.sort;

import java.util.Arrays;

/**
 * Created by Zxd on 2021/1/5 11:08
 */
//选择排序
public class SelectionSort {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < a.length; j++) {
                if (greater(a[minIndex], a[j])) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                exchange(a,minIndex,i);
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
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
