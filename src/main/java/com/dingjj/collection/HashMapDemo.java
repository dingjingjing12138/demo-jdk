package com.dingjj.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author : dingjj@pingpongx.com
 * @description:
 * @date : 2021/8/25
 */
public class HashMapDemo {

    public static void main(String[] args) {
        final HashMap<Object, Object> map = new HashMap<>();
        map.put("", "");

        final TreeMap<Integer, Object> treeMap = new TreeMap<>((o1, o2) -> o2 - o1);
    }
}
