package com.ritesh.testcodes;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortCollection {


    public static void main(String[] argv) throws Exception {

        Integer[] unsortedArray = {34, 21, 0, 5, 99, 76};

        // getting the list view of Array
        List<Integer> list = Arrays.asList(unsortedArray);

        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        //Post java 8
        int[] unsortedIntArray = {34, 21, 0, 5, 99, 76};
        List<Integer> java8IntList = Arrays.stream(unsortedIntArray)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Before sorting " +java8IntList);
        java8IntList.sort(Comparator.naturalOrder());
        System.out.println("After sorting " +java8IntList);

        //  Another way of sorting it by stream and Lambdas
        IntStream.of(unsortedIntArray)
                .sorted().boxed()
                .collect(Collectors.toList())
                .forEach(x -> System.out.print(x + ","));
    }


}
