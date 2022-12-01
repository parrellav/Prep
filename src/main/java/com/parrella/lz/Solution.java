package com.parrella.lz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println("starting!");

        // intiialize users
        List<Attorney> attorney = new ArrayList<Attorney>();

        attorney.add(new Attorney("Miguel Migs", 72));
        attorney.add(new Attorney("Lars", 55));
        attorney.add(new Attorney("John Smith", 21));
        attorney.add(new Attorney("John Smith", 23));
        attorney.add(new Attorney("tim jenkins", 1));
        attorney.add(new Attorney("Michelle Banks", 3));
        attorney.add(new Attorney("Mike Jones", 5));

        // sort Attorney by last name
        /********* good answer here *********/
        Collections.sort(attorney, (o1, o2) -> {
            String[] o1Split = o1.getName().split(" ");
            String[] o2Split = o2.getName().split(" ");
            if (o1Split.length > 1 && o2Split.length > 1) {
                return o1.getName().toLowerCase().split(" ")[1].compareTo(o2.getName().toLowerCase().split(" ")[1]);
            }
            else {
                return (o1.getRank() - o2.getRank());
            }

        });

        /************************************/

        attorney.forEach(u -> System.out.println(u.getName()));
    }

}
