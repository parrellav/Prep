package com.parrella.lex;

import java.util.*;
import java.util.stream.Collectors;

public class CompareStrings {

    public static class Lex implements Comparable<Lex> {
        public char aChar;
        public int amount;

        public Lex(char myChar, int myAmount) {
            aChar = myChar;
            amount = myAmount;
        }

        public int compareTo(Lex aLex) {
            int val = this.aChar - aLex.aChar;
            if (0 == val) return this.amount - aLex.amount;
            return val;
        }
    }

    public static Lex makeLex(String str) {
        char aChar = 'z';
        int count = 0;

        for (char myChar : str.toCharArray()) {
            if (myChar < aChar) {
                aChar = myChar;
                count = 1;
            }
            else if (myChar == aChar) {
                count ++;
            }
        }
        return new Lex(aChar, count);
    }

    public static List<Integer> compareStrings(List<String> str1, List<String> str2) {
        List<Integer> result = new ArrayList<>();
        List<Lex> firstLexList = str1.stream().map(aString -> makeLex(aString)).collect(Collectors.toList());
        List<Lex> secondLexList = str2.stream().map(aString -> makeLex(aString)).collect(Collectors.toList());

        for (Lex aLex : secondLexList) {
            int count = 0;
            for (Lex anotherLex : firstLexList) {
                if (0 < aLex.compareTo(anotherLex)) {
                    count++;
                }
            }
            System.out.println("bob");
            result.add(count);
        }

        return result;
    }

    public static void main(String[] args) {
        String str1 = "cat lllonniy bbbbd late cucumber saalt";
        String str2 = "loplply bkjkbs bat";
        compareStrings(Arrays.asList(str1.split(" ")), Arrays.asList(str2.split(" ")));
    }
}
