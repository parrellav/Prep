package com.parrella.map;

import java.util.HashMap;
import java.util.List;


public class MergeTest {

    public static void main(String[] args) {
        var words = List.of("Foo", "Bar", "Foo", "Buzz", "Foo", "Buzz", "Fizz", "Fizz");
        var myMap = new HashMap<String, Integer>();
        words.forEach(word -> {
            myMap.merge(word, 1, Integer::sum);
        });
        myMap.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
