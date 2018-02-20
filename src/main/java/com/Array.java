package com;

public class Array {

    private String[] array;
    private int size = 100;


    public Array(){
        array = new String[size];
    }
    public Array(int size) {
        this.size = size;
        array = new String[size];
    }

    private boolean isAvailableofIndex(int index) {

        if(index >= size){
            return false;
        }

        if(array[index].isEmpty() == true) {
           return false;
        }

        return true;
    }

    public boolean add(int index, String value) {
        System.out.println("add index : "+ index + " value : " + value );
        if(index >= size) {
            return false;
        }

        array[index] = value;
        return true;
    }

    public boolean removeofIndex(int index) {

        if(isAvailableofIndex(index) == true) {
            array[index] = null;
            return true;
        }
        return false;
    }

    public String getValue(int index) {

        System.out.println("getValue index : "+ index );
      if(isAvailableofIndex(index) == true) {
            return array[index];
        }

        return null;
    }

}
