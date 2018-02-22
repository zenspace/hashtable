package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashTable<K, V> {

  static final Logger logger = LoggerFactory.getLogger(HashTable.class);

  private Array table;    // 해쉬 테이블
  private int size = 100; // 해쉬 테이블 크기


  /**
   * 생성자에서 해쉬테이블 디폴트 크기를 100으로 설정 한다.
   */
  public HashTable() {
    this.table = new Array(size);
  }

  /**
   * 해쉬 테이블 생성자에서 테이블 크기를 받아서 설정 해준다.
   *
   * @param size 테이블 크기
   */
  public HashTable(int size) {
    this.size = size;
    this.table = new Array(size);
  }

  /**
   * key값을 받아 해쉬 값을 구하고 해쉬값을 mod 연산을 하여 index 값을 만든다. 구해진 index값에 value를 저장한다.
   *
   * @param key   키값 해쉬값을 구할 때 사용된다.
   * @param value value 값
   * @return 구해진 hashcode % size 값이 size보다 작으면 true를 리턴하고 크면 false를 리턴한다.
   */
  public boolean put(K key, V value) {

    int hashValue = key.hashCode() % size;

    if (hashValue >= size) {
      logger.warn("wrong hash code value");
      return false;
    }
    table.add(hashValue, key, value);
    return true;
  }

  /**
   * key와 매칭되는 노드를 삭제한다.
   *
   * @param key 삭제할 노드의 key
   * @return
   */
  public boolean Remove(K key) {
    int hashValue = key.hashCode() % size;

    return table.removeofIndex(hashValue, key);
  }

  /**
   * 해쉬 테이블에서 key 값과 매칭 되는 node를 찾는다.
   *
   * @param key 찾고 싶은 node의 key
   * @return 찾았으면 value를 반환 한다. 매칭된 node가 없다면 null를 반환한다.
   */
  public V getValue(K key) {
    int hashValue = key.hashCode() % size;

    if (hashValue >= size) {
      logger.warn("wrong hash code value");
      return null;
    }

    return (V) table.getValue(hashValue, key);
  }


}
