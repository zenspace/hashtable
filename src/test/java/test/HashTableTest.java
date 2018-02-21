package test;

import com.HashTable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;
import util.StopWatch;

import java.util.Hashtable;

import static org.junit.Assert.assertEquals;

public class HashTableTest {

    @Test
    public void Remove() throws Exception{
        HashTable<String,String> tb = new HashTable(2);

         for(Integer i = 0 ; i < 100; i++) {
            tb.put(i.toString(), i.toString());
        }

        assertEquals("1",tb.getValue("1"));
        assertEquals("0",tb.getValue("0"));
        assertEquals("3",tb.getValue("3"));


        tb.Remove("44");
        tb.Remove("0");
        tb.Remove("99");
        tb.Remove("85");
        assertEquals(null,tb.getValue("99"));
        assertEquals(null,tb.getValue("44"));
        assertEquals(null,tb.getValue("85"));
        assertEquals(null,tb.getValue("0"));

          for(Integer i = 0 ; i < 100; i++) {
              if(i == 0 || i == 44 || i == 99 || i==85) {
                  assertEquals(null,tb.getValue(i.toString()));
              }
              assertEquals(i.toString(),i.toString());
        }

    }
//    @Test
//    public void Add() throws Exception{
//        System.out.println("Welcome to Hello");
//
//        HashTable<String,String> tb = new HashTable(10000);
//
//        StopWatch watch = new StopWatch("insert");
//        StopWatch watch2 = new StopWatch("search");
//
//        watch.start();
//        for(Integer i = 0 ; i < 1000001 ; i++) {
//            tb.put(i.toString(), i.toString());
//        }
//        watch.stop();
//
//
//        watch2.start();
//        assertEquals("1",tb.getValue("1"));
//        assertEquals("45109",tb.getValue("45109"));
//        assertEquals("189580",tb.getValue("189580"));
//        assertEquals("1000000",tb.getValue("1000000"));
//        watch2.stop();
//
//        watch.Print();
//        watch2.Print();
//    }

//    @Test
//    public void HashTable() throws Exception{
//        Hashtable<String,String> tb = new Hashtable<>(10000);
//
//        StopWatch watch = new StopWatch("insert");
//        StopWatch watch2 = new StopWatch("search");
//
//        watch.start();
//        for(Integer i = 0 ; i < 10000 ; i++) {
//           tb.put(i.toString(), i.toString());
//        }
//        watch.stop();
//
//         watch.Print();
//    }

}
