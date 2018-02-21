package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashTableExample {

    public static void main(String[] args){

        final Logger logger = LoggerFactory.getLogger(HashTableExample.class);
        logger.info("hello");

        HashTable tb = new HashTable();

        tb.put("1", "1");
        tb.put("2", "2");
        tb.put("3", "3");
        tb.put("4", "4");



    }
}
