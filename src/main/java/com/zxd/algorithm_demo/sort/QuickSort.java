package com.zxd.algorithm_demo.sort;

import java.util.Arrays;

/**
 * Created by Zxd on 2021/1/5 11:08
 */
//快速排序
public class QuickSort {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        //以lo为基准，切分成两部分，左边比基准数小，右边比基准数大，并返回分好后的lo的索引
        int keyIndex = partition(a, lo, hi);
        //左边排序
        sort(a, lo, keyIndex - 1);
        //右边排序
        sort(a, keyIndex + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        //已key = a[lo]，对索引lo+1～hi进行遍历
        //定义两个指针，分别指向最左和最右，依次遍历右指针和左指针，使找到右指针指向的数比基准小，左指针指向的数比基准大，然后交换。遍历到right>=left为止
        //对于每次遍历右指针，找到了即右指针停止；找不到的话，遍历到right=lo
        //对于每次遍历左指针，找到了即左指针停止；找不到的话，遍历到left=hi
        //如果外部循环结束了，说明索引lo+1～hi已经有序，此时左右指针重合，把基数和
        Comparable key = a[lo];
        int left = lo;
        int right = hi+1;
        while (true) {

        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    public static void exchange(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {8,7,6,5,4,3,2,1};
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
