package test;

import com.HashTable;
import java.util.Hashtable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;
import util.StopWatch;


import static org.junit.Assert.assertEquals;

public class HashTableTest {

  /**
   * 삭제 테스트 값을 put 한 후에 정상적으로 값이 들어간는지 확인한다. 그 후 key와 매칭된 node를 삭제한다.
   * 삭제한 노드가 정상적으로 지워졌는지 확인한다.
   * @throws Exception
   */
  @Test
  public void Remove() throws Exception {
    HashTable<String, String> tb = new HashTable(2);

    for (Integer i = 0; i < 100; i++) {
      tb.put(i.toString(), i.toString());
    }

    assertEquals("1", tb.getValue("1"));
    assertEquals("0", tb.getValue("0"));
    assertEquals("3", tb.getValue("3"));
    tb.Remove("44");
    tb.Remove("0");
    tb.Remove("99");
    tb.Remove("85");
    assertEquals(null, tb.getValue("99"));
    assertEquals(null, tb.getValue("44"));
    assertEquals(null, tb.getValue("85"));
    assertEquals(null, tb.getValue("0"));

    for (Integer i = 0; i < 100; i++) {
      if (i == 0 || i == 44 || i == 99 || i == 85) {
        assertEquals(null, tb.getValue(i.toString()));
      }
      assertEquals(i.toString(), i.toString());
    }

  }

  /**
   * 해쉬 테이블에 정상적으로 추가 되는지 확인 한다.
   * @throws Exception
   */
  @Test
  public void Add() throws Exception {
    System.out.println("Welcome to Hello");

    HashTable<String, String> tb = new HashTable(10000);

    StopWatch watch = new StopWatch("insert");
    StopWatch watch2 = new StopWatch("search");

    watch.start();
    for (Integer i = 0; i < 1000001; i++) {
      tb.put(i.toString(), i.toString());
    }
    watch.stop();

    watch2.start();
    assertEquals("1", tb.getValue("1"));
    assertEquals("45109", tb.getValue("45109"));
    assertEquals("189580", tb.getValue("189580"));
    assertEquals("1000000", tb.getValue("1000000"));
    watch2.stop();

    watch.Print();
    watch2.Print();
  }

  /**
   * 해쉬값이 충돌된 상황에서도 정상적으로 값이 들어갔는지 확인 한다.
   * @throws Exception
   */
  @Test
  public void collisionAddTest() throws Exception {

    HashTable<String, String> tb = new HashTable(100);

    for (Integer i = 0; i < 1000001; i++) {
      tb.put(i.toString(), i.toString());
    }

    for (Integer i = 0; i < 10000; i++) {
      assertEquals(i.toString(), tb.getValue(i.toString()));
    }
  }

  /**
   * 해쉬값이 충돌할 때 정상적으로 삭제 되는지 테스트 한다.
   * @throws Exception
   */
  @Test
  public void collisionRemove() throws Exception {
    HashTable<String, String> tb = new HashTable<>(100);

    for (Integer i = 0; i < 1000001; i++) {
      tb.put(i.toString(), i.toString());
    }

    for (Integer i = 0; i < 10000; i++) {
      assertEquals(i.toString(), tb.getValue(i.toString()));
    }

    tb.Remove("44");
    tb.Remove("0");
    tb.Remove("99");
    tb.Remove("85");

    for (Integer i = 0; i < 100; i++) {
      if (i == 0 || i == 44 || i == 99 || i == 85) {
        assertEquals(null, tb.getValue(i.toString()));
      }
      assertEquals(i.toString(), i.toString());
    }
  }

}
