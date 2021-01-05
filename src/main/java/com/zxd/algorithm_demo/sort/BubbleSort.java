package com.zxd.algorithm_demo.sort;

import java.util.Arrays;

/**
 * Created by Zxd on 2021/1/5 11:08
 */
//冒泡排序
public class BubbleSort {
    public static void sort(Comparable[] a) {
        boolean didSwap;
        for (int i = a.length-1; i>0; i--) {
            didSwap = false;
            for (int j = 0; j < i; j++) {
                if (greater(a[j], a[j + 1])) {
                    exchange(a, j, j + 1);
                    didSwap = true;
                }
            }
            if (!didSwap) {//最好情况 :遍历一遍，未发生交换O(n)
                return;
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
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
