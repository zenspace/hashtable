package com;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Array<K,V> {

    private LinkedList<Node> array[];
    private int size = 100;


    /**
     * 생성자에서 해쉬 테이블 크기를 디폴트 값 size로 크기를 잡아준다.
     */
    public Array(){
        System.out.println("add index : " );
        array = new LinkedList[size];
    }

    /**
     * 생성자에서 해쉬 테이블 크기를 파라미터로 넘어논 size로 잡아준다.
     * @param size 해쉬 테이블 크기
     */
    public Array(int size) {
        this.size = size;
        System.out.println("add index : " + size);
       array = new LinkedList[size];
    }

    private boolean isAvailableofIndex(int index) {

        if(index >= size){
            return false;
        }


        return true;
    }

    public boolean add(int index, K key, V value) {
        if(index >= size) {
            return false;
        }
        Node node = new Node(key, value);
         if(key.toString().equals("5070")) {
            System.out.println("add key 5070 index: " + index);
        }

        if(array[index] == null) {
            array[index] = new LinkedList<>();;

        }

        array[index].add(node);
        return true;
    }

    public boolean removeofIndex(int index) {

        if(isAvailableofIndex(index) == true) {
            array[index] = null;
            return true;
        }
        return false;
    }


    public V getValue(int index, K key) {

        int size = array[index].size();

        synchronized (array[index]) {
            for (int i = 0; i < size; i++) {

                if (array[index].get(i).getKey().equals(key) == true) {
                    return (V) array[index].get(i).getValue();

                }
            }

            return null;
        }
    }
}
