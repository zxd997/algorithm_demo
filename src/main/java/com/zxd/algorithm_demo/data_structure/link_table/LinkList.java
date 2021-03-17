package com.zxd.algorithm_demo.data_structure.link_table;

import java.util.Iterator;

//链表
//单向链表
public class LinkList<T> implements Iterable<T>{
    private Node head;
    private int N;

    private class Node{
        private T item;
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkList() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public void clear() {
        this.head.next = null;
        this.N = 0;
    }
    public boolean isEmpty(){
        return N == 0;
    }

    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("索引不合法");
        }
        Node temp = head.next;
        for (int j = 0; j < i; j++) {
            temp = temp.next;
        }
        return temp.item;
    }

    public int length() {
        return N;
    }
    //从线性表的第i个元素之前插入一个值为t的元素
    public void insert(int i, T t) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("索引不合法");
        }
        Node prev = head;
        for (int j = 0; j < i; j++) {
            prev = prev.next;
        }
        Node n = prev.next;
        prev.next = new Node(t, n);
        N++;
    }

    //向线性表中添加一个元素t
    public void insert(T t) {
        Node n = head;
//        for (; ; ) {
//            Node temp;
//            if ((temp = n.next) == null) {
//                n.next = new Node(t, null);
//                N++;
//                return;
//            }
//            n = temp;
//        }
//        while ()
    }

    //删除并返回第i个元素
    public T remove(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("数组越界异常");
        }
        Node prev = head;
        for (int j = 0; j < i; j++) {
            prev = prev.next;
        }
        Node n = prev.next;
        prev.next = n.next;
        N--;
        return n.item;
    }

    //返回线性表中首次出现的指定元素的位序号，若不存在返回-1
    public int indexOf(T t) {
        Node n = head;
        for (int j = 0; j < N; j++) {
            if ((n = n.next) == t) {
                return j;
            }
        }
        return -1;
    }
    @Override
    public Iterator<T> iterator() {
        return new MyLinkIterator();
    }

    private class MyLinkIterator implements Iterator{

        private Node n;

        public MyLinkIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
    public void print() {
        forEach(t -> {
            if (t instanceof Integer) {
                System.out.println((Integer) t);
            }
        });
//        Node t = head;
//        while ((t=t.next) != null) {
//            System.out.println(t.item);
//        }
        System.out.println("////");
    }

    public static void main(String[] args) {
        LinkList<Integer> linkList = new LinkList<>();
        linkList.insert(1);
        linkList.insert(3);
        linkList.insert(1,2);
        linkList.insert(2,4);
        linkList.insert(2,5);
        linkList.print();
        linkList.remove(4);
        linkList.print();
        linkList.remove(0);
        linkList.print();
    }
}
