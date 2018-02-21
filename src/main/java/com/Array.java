package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.ListIterator;

public class Array<K,V> {

    static final Logger logger = LoggerFactory.getLogger(Array.class);

    private LinkedList<Node> array[];
    private int size = 100;


    /**
     * 생성자에서 해쉬 테이블 크기를 디폴트 값 size로 크기를 잡아준다.
     */
    public Array(){
        logger.info("Array capacity : " + size);
        array = new LinkedList[size];
    }

    /**
     * 생성자에서 해쉬 테이블 크기를 파라미터로 넘어논 size로 잡아준다.
     * @param size 해쉬 테이블 크기
     */
    public Array(int size) {
        this.size = size;
        logger.info("Array capacity : " + size);
       array = new LinkedList[size];
    }

    /**
     * 해쉬 테이블에서 사용 가능한 index인지 체크 한다.
     * @param index 해쉬 테이블 접근을 위해 사용하는 index
     * @return 사용 가능하다면 true, 사용 할 수 없는 범위이면 false
     */
    private boolean isAvailableofIndex(int index) {

        if(index >= size){
            logger.error("index size over");
            return false;
        }

        return true;
    }

    /**
     * key,value 쌍으로 노드를 생성하고 생성된 노드를 추가한다.
     * @param index 추가 되어야 할 테이블의 index
     * @param key   추가 될 node의 key
     * @param value 추가 될 node의 value
     * @return 추가가 성공적 했다면 true, 실패 했다면 false
     */
    public boolean add(int index, K key, V value) {
        if(index >= size) {
            return false;
        }
        Node node = new Node(key, value);


        if(array[index] == null) {
            array[index] = new LinkedList<>();;

        }

        array[index].add(node);
        return true;
    }

    /**
     * 삭제 할 노드를 찾아서 노드를 삭제한다.
     * @param index 삭제할 노드의 테이블 index
     * @param key 삭제할 노드의 key
     * @return 삭제 성공 true, 삭제 할 노드가 없거나 삭제를 하지 못 했을 때 false
     */

    public boolean removeofIndex(int index, K key) {

        if(isAvailableofIndex(index) == false) {
            return false;
        }

        ListIterator<Node> iterator = array[index].listIterator();

        while (iterator.hasNext()) {
            if(iterator.next().getKey().equals(key) == true) {
                iterator.remove();
                return true;
            }
        }
        return true;
    }


    /**
     * key와 매칭된 노드의 value를 반환 한다.
     * @param index 노드가 존재하는 테이블 index
     * @param key  찾아야 할 노드의 key
     * @return 노드를 성공적으로 찾았으면 value를 반환 한다. 찾지 못했으면 null를 반환 한다.
     */
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
