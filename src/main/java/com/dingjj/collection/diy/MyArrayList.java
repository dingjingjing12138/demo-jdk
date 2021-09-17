package com.dingjj.collection.diy;

/**
 * @author : dingjj@pingpongx.com
 * @description:
 * @date : 2021/8/24
 */
public class MyArrayList<E> {

    private Object[] data;

    private int size;

    private final int DEFAULT_SIZE = 3;

    public void add(E e) {

        ensureEnoughSize();
        data[size++] = e;
    }

    public E get(int index) {

        rangeCheck(index);
        return (E) data[index];
    }

    public E remove(int index) {
        //[1,2,3,4] 1
        //[1,3,4,4]
        rangeCheck(index);
        E old = (E) data[index];

        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[size - index] = null;

        return old;
    }

    public void add(int index, E e) {
        rangeCheck(index);

        ensureEnoughSize();
        //[1,2,3]
        //[1,5,2,3] 4-1
        //[1,2,5,3,4]
        //[1,2,3,3,4]
        //[1,2,5,3,3,4] 5个元素的时候需要移动3个元素 size - index 5- 2
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    public E set(int index, E e) {
        rangeCheck(index);
        ensureEnoughSize();
        //[1,2,3]
        //[5,2,3]  0 5
        E old = (E) data[index];
        data[index] = e;

        return old;
    }

    public void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public MyArrayList() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public MyArrayList(int size) {
        this.data = new Object[size];
    }

    public void ensureEnoughSize() {

        if (this.size >= this.data.length - 1) {
            int newCapacity = data.length  + (data.length >> 1);
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(this.data, 0, newArray, 0, data.length);

            this.data = newArray;
        }
    }

    public void getAllElement() {
        System.out.print("[");
        for (Object datum : data) {
            System.out.print(datum + " ,");
        }
        System.out.print("]");
        System.out.println("\n");
    }


    public static void main(String[] args) {

/*        int a = 4;
        int b =4 >> 1;
        System.out.println(a + b);*/
        final MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");

        myArrayList.add("4");

        myArrayList.getAllElement();

/*        myArrayList.set(8,"8");

        System.out.println("删除之后的数据元素为:");
        myArrayList.getAllElement();*/

/*        System.out.println("删除之后的数据元素为:");
        myArrayList.remove(1);

        myArrayList.getAllElement();*/

/*        System.out.println("增加之后的数据元素为:");
        myArrayList.add(0, "8");

        myArrayList.getAllElement();*/

        //System.out.println(myArrayList.get(0));
    }

}
