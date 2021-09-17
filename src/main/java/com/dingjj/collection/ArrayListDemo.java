package com.dingjj.collection;

import java.util.ArrayList;

/**
 * @author : dingjj@pingpongx.com
 * @description:
 * @date : 2021/8/23
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("张三");
        arrayList.set(1, "李四");
        final String s = arrayList.get(0);
        arrayList.remove(1);
    }
}
