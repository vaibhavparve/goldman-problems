package com.practise.goldman_problems.medium;

import java.util.Map;

public class LruCache {
/*
* talking points.
* This is not thread safe implementation. This is implementation using doubly linkedList and HashMa,
*  its most common implementation of this LRU cache.
*
* Think of all the operation mostly removeNode, addTOHead and moveToHead.
*
*
* */
    //Doubly linked list node
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private final Node head; //most recent dummy head
    private final Node tail; //Most recent dummy tail

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {

            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);

            if (cache.size() > capacity) {
                Node tail = removeTail();
                cache.remove(tail.key);
            }
        }
    }

    private Node removeTail() {
        Node lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        //always think of adding connectivity of all 3 nodes if we consider (0,0) as head and tail. then to add (1,1)
        node.prev = head;
        node.next = head.prev.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    public static void main(String[] args) {
        System.out.println("1. Basic LRU Cache Test:");

        LruCache cache = new LruCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("get(1): " + cache.get(1)); // returns 1

        cache.put(3, 3); // evicts key 2
        System.out.println("get(2): " + cache.get(2)); // returns -1 (not found)

        cache.put(4, 4); // evicts key 1
        System.out.println("get(1): " + cache.get(1)); // returns -1 (not found)
        System.out.println("get(3): " + cache.get(3)); // returns 3
        System.out.println("get(4): " + cache.get(4)); // returns 4

        System.out.println();
    }
}
