package com.zxd.algorithm_demo.sort.insert_;

import java.util.Arrays;

/**
 * Created by Zxd on 2021/1/5 11:08
 */
//希尔排序
public class ShellSort {
    public static void sort(Comparable[] a) {
        //0,1,2,3,4,5,6,7,8,9
        for (int h = a.length / 2; h > 0; h = h / 2) {//h=增长量
            for (int i = h; i < a.length; i++) {//先找到第一个数，对依次每个数在所在组内排序，跨组遍历（如十个数，h=2，分为两组第一个数在第一组，第二个数在第二组）
                //0,2,4,6,8
                // 1,3,5,7,9
                for (int j = i; j >= h; j -= h) {
                    if (greater(a[j - h], a[j]))
                        exchange(a, j - h, j);
                    else
                        break;
                }
            }
        }
    }

    public static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    public static void exchange(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 3, 4, 8, 7, 5};
//        Integer[] arr = {1,2,3,4,5,6};

        ShellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
