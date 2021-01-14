package com.zxd.algorithm_demo.sort;

import java.util.Arrays;

/**
 * Created by Zxd on 2021/1/5 11:08
 */
//归并排序
    //分治算法
    //空间换时间
    //时间复杂度 =层数*每次比较次数=log2n*2^log2n = nlogn =O（nlogn）
    //空间复杂度 = O(n)
public class MergeSort {
    private static Comparable[] assist;
    public static void sort(Comparable[] a) {
        assist = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        //分到不能分为止
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        //如：左：1，4，7：右：2，3，6
        //通过三个指针，一个指向辅助数组，一个指向左子组，一个指向右子组
        int i  = lo;//对齐合并
        int p1 = lo;
        int p2 = mid + 1;
        //移动指针，比较，一直比较到有一个p不能再移动了
        while (p1 <= mid && p2 <= hi) {
            if (less(a[p1], a[p2])) {
                assist[i++] = a[p1++];
            } else {
                assist[i++] = a[p2++];
            } 
        }
        //此时，可能存在，左或者右p还没移动完
        //如果p1未移动完，把剩下的值直接遍历到assist（因为归并到此，剩下的一定有序）
        while (p1 <= mid) {
            assist[i++] = a[p1++]; 
        }
        //如果p2未移动完，把剩下的值直接遍历到assist（因为归并到此，剩下的一定有序）
        while (p2 <= hi) {
            assist[i++] = a[p2++];
        }
        //把此段排好序的数组复制到原数组中
        for (int index = lo; index <= hi; index++) {
            a[index] = assist[index];
        }

    }

//    public static void exchange(Comparable[] a, int i, int j) {
//        Comparable temp;
//        temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }

    public static void main(String[] args) {
        Integer[] arr = {8,7,6,5,4,3,2,1};
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
