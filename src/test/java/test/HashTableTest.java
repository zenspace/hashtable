package test;

import com.HashTable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class HashTableTest {

    @Test
    public void Add() throws Exception{
        System.out.println("Welcome to Hello");

        HashTable tb = new HashTable();

        tb.put("1", "1");
        tb.put("2", "2");
        tb.put("3", "3");
        tb.put("4", "4");

        assertEquals("1",tb.getValue("1"));
        assertEquals("2",tb.getValue("2"));
        assertEquals("3",tb.getValue("3"));
        assertEquals("4",tb.getValue("4"));
    }

}
