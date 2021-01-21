package com.zxd.algorithm_demo.data_structure.linear_table;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

//线性表
//        第一个数据元素没有前驱，这个数据元素被称为开始节点；
//        最后一个数据元素没有后继，这个数据元素被称为终端节点；
//        除了第一个和最后一个数据元素外，其他数据元素有且仅有一个前驱和一个后继。
//              顺序表
                    //时间复杂度 get（）:O(1)   insert(): 平均O(n) 最好O(1) 最坏O(n)  remove() 平均O(n)
public class SequenceList<T> implements Iterable<T>{
    private T[] elements;
    //当前线性表的长度；
    private int N; //注意：是该数据结构是连续的

    public SequenceList(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.N = 0;
    }

    public void clear() {
        this.elements = null;
        this.N = 0;
    }
    public boolean isEmpty(){
        return N == 0;
    }

    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("数组越界异常");
        }
        return elements[i];
    }

    public int length() {
        return N;
    }
    //从线性表的第i个元素之前插入一个值为t的元素
    public void insert(int i, T t) {
        if (elements.length == N) {
            resize(elements.length * 2);
        }
        if (i < 0 || i >= N) {
            throw new RuntimeException("插入为止不合法");
        }
        //i后面的元素依次往后移动
        for (int index = N - 1; index >= i; index--) {
            elements[index + 1] = elements[index];
        }
        elements[i] = t;
        N++;
    }

    //向线性表中添加一个元素t
    public void insert(T t) {
        if (elements.length == N) {
            resize(elements.length * 2);
        }
        elements[N++] = t;
    }

    //删除并返回第i个元素
    public T remove(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("数组越界异常");
        }
        T temp = elements[i];
        for (int j = i; j < N-1; j++) {
            elements[j] = elements[j + 1];
        }
        elements[N - 1] = null;
        N--;
        if (N < elements.length / 4) {
            resize(elements.length / 2);
        }
        return temp;
    }

    //返回线性表中首次出现的指定元素的位序号，若不存在返回-1
    public int indexOf(T t) {
        for (int i = 0; i < N; i++) {
            if (t == elements[i]) {
                return i;
            }
        }
        return -1;
    }

    //容量可变
    public void resize(int newSize) {
        T[] temp = elements;
        elements = (T[]) new Object[newSize];
        for (int i = 0; i < N; i++) {
            elements[i] = temp[i];
        }
    }
    //实现遍历
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator{
        private int cursor;

        public MyIterator() {
            this.cursor = 0;
        }
        @Override
        public boolean hasNext() {
            return cursor < N;
        }

        @Override
        public Object next() {
            return elements[cursor++];
        }
    }

    public static void main(String[] args) {
        SequenceList<Integer> sequenceList = new SequenceList<>(7);
        sequenceList.insert(2);
        sequenceList.insert(0,1);
        sequenceList.insert(4);
        sequenceList.insert(2,3);
        sequenceList.insert(5);
        sequenceList.insert(6);
        for (Integer integer : sequenceList) {
            System.out.println(integer);
        }
        Iterator<Integer> iterator = sequenceList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(Arrays.toString(sequenceList.elements));
        sequenceList.remove(0);
        System.out.println(Arrays.toString(sequenceList.elements));
        sequenceList.remove(2);
        System.out.println(Arrays.toString(sequenceList.elements));
        sequenceList.remove(3);
        System.out.println(Arrays.toString(sequenceList.elements));
        System.out.println(sequenceList.N);
        System.out.println("///////");
        SequenceList<Integer> s1 = new SequenceList<>(2);
        s1.insert(1);
        s1.insert(2);
        s1.insert(3);
        for (Integer integer : s1) {
            System.out.println(integer);
        }
    }
}
