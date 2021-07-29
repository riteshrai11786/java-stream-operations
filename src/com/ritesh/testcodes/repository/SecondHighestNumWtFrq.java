package com.ritesh.testcodes.repository;

import java.util.*;
import java.util.stream.IntStream;

public class SecondHighestNumWtFrq {

    int[] arr = {22, 1, 5, 3, 22, 1, 4, 5, 2, 13};




   /* public static void main(String[] args) {
        // TempArr {largest, secondLargest, Feq}
        int[] myArr = new int[]{12, 1, 4, 5, 1, 0};
        //int[] resArr = new int[]{0, 0, 0};
    }*/

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("#condo");
        strings.add("#pool");
        strings.add("#community");
        strings.add("#community");
        strings.add("#condo");

        Map<String, Integer> wc = new HashMap<>();

        for (String string : strings) {
            if(wc.containsKey(string))
                wc.put(string, wc.get(string) + 1);
            else
                wc.put(string, 1);
        }

        TreeMap<String, Integer> sorted = new TreeMap<>();
        sorted.putAll(wc);

        System.out.println(wc);

        wc.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::print);


        //Map<Product, Policy> prodCache = new HashMap<>(); // top 10 elements


    }



    private static void secLarNum(int [] myArr) {
        int largest = 0;
        int largestFreq = 0;
        int seclargest = 0;
        int secLarFreq = 0;

        // Assuming the list length is greater than 1
        largest = myArr[0]; //3,4,1,4,5
        largestFreq = 1;

        for(int i = 1; i< myArr.length; i++) {
            if(myArr[i] > largest) {
                seclargest = largest;
                secLarFreq = largestFreq;
                largest=myArr[i];
                largestFreq = 1;
            } else if(myArr[i] == largest)
                largestFreq =+ 1;
            else if(myArr[i] > seclargest) {
                seclargest=myArr[i];
                secLarFreq = 1;
            } else if(myArr[i] == seclargest)
                secLarFreq =+ 1;
        }
    }



}
