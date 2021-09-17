package com.dingjj.collection.diy;

import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @author : dingjj@pingpongx.com
 * @description:
 * @date : 2021/8/25
 */
public class MyLinkedList<E> {


    private Node first;
    private Node last;
    private E data;

    public void add(E e){

    }


    public static class Node<E> {

        private Node prev;
        private Node next;
        private E item;

        public Node(Node prev, Node next, E item) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }

    public static void main(String[] args) {
        final ArrayList<String> objects = new ArrayList<>();
        objects.add(null);
        System.out.println(CollectionUtils.isEmpty(objects));

    }
}
