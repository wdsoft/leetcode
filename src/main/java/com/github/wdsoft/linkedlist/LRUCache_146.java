package com.github.wdsoft.linkedlist;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by jwd on 2018/9/24.
 */
public class LRUCache_146 {

    private int CAPACITY;
    private Deque<Integer> list;
    private Map<Integer, Integer> map;

    public LRUCache_146(int capacity) {
        this.CAPACITY = capacity;
        this.list = new LinkedList<>();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove(key);
            list.addFirst(key);
        }
        Integer value = map.get(key);
        if (value != null) {
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (list.contains(key)) {
            list.remove(key);
            list.addFirst(key);
        } else if (list.size() >= CAPACITY) {
            int removeLast = list.removeLast();
            map.remove(removeLast);
            list.addFirst(key);
        } else {
            list.addFirst(key);
        }

        map.put(key, value);
    }
}
