package com.solar.practise.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 最近最少被使用
 *
 * @author huangzhibo
 * @date 2019-10-23
 */
public class LRUCache<T> {

    private class Node {
        String key;
        T value;
        Node pre, next;
        Node(String key, T value){
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }

    private volatile AtomicInteger capacity;
    private volatile AtomicInteger size = new AtomicInteger(0);
    private Node head;
    private Node tail;

    private void moveToHead(Node target){
        if (head == null){
            head = target;
            return;
        }
        target.pre.next = target.next;
        target.next.pre = target.pre;

        head.pre = target;
        target.next = head;
        head = target;
    }

    public LRUCache(int capacity){
        this.capacity = new AtomicInteger(capacity);
    }

    public T peek(String key){
        Node target = findNode(key);
        if (target != null){
            return target.value;
        }
        return null;
    }

    private Node findNode(String key){
        Node cur = head;
        for (;;){

            if (cur == null){
                return null;
            }

            if (cur.key.equals(key)){
                moveToHead(cur);
                return cur;
            }

            cur = cur.next;

        }
    }

    public void offer(String key, T value){

        Node existNode = findNode(key);

        if (existNode != null){
            head.value = value;
            return;
        }

        Node newNode = new Node(key, value);

        if (head == null){
            head = newNode;
            tail = newNode;
            size.addAndGet(1);
            return;
        }

        if (size.get() < capacity.get()){
            head.pre = newNode;
            newNode.next = head;
            head = newNode;
            size.addAndGet(1);
        } else {

            tail.pre.next = null;
            tail.pre = null;

            head.pre = newNode;
            newNode.next = head;
            head = newNode;


        }



    }

}
