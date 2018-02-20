package com;
import java.util.ArrayList;
import java.util.List;


public class HashTable {

    private Array table;     // 해쉬 테이블
    private int size = 100;               // 해쉬 테이블 크기

    /**
     * 생성자에서 해쉬테이블 디폴트 크기를 100으로 설정 한다.
     */
    public HashTable(){
        System.out.println("default : " + size);
        this.table = new Array(size);
    }

    /**
     * 해쉬 테이블 생성자에서 테이블 크기를 받아서 설정 해준다.
     * @param size 테이블 크기
     */
    public HashTable(int size){
        this.size = size;
        System.out.println("opt size : " + size);
       this.table = new Array(size);
    }

    /**
     * key값을 받아 해쉬 값을 구하고 해쉬값을 mod 연산을 하여 index 값을 만든다. 구해진 index값에 value를 저장한다.
     * @param key 키값 해쉬값을 구할 때 사용된다.
     * @param value value 값
     * @return 구해진 hashcode % size 값이 size보다 작으면 true를 리턴하고 크면 false를 리턴한다.
     */
    public boolean put(String key, String value) {

        int hashValue = key.hashCode() % size ;

        if(hashValue >= size) {
            return false;
        }
        System.out.println( "hashcode value : " + hashValue);
        table.add(hashValue, value);
//        table.add(value);
        return true;
    }

    public String getValue(String key) {
        int hashValue = key.hashCode() % size;

        if(hashValue >= size){
            return null;
        }

        return table.getValue(hashValue);
    }


}
