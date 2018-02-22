package com;

public class Node<K, V> {
  private K key;
  private V value;

  public Node(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public K getKey() {
    return this.key;
  }

  public V getValue() {
    return this.value;
  }

}
