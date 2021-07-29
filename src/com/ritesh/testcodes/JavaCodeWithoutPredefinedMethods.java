package com.ritesh.testcodes;

import java.util.Arrays;
import java.util.stream.IntStream;

public class JavaCodeWithoutPredefinedMethods {

    public static void main(String [] args) {
        int [] arr = {11,30,29,76,0,99,1};
        boolean isSorted = false;

        int prevNum = arr[0];

        // Find if the array is already sorted
        for(int idx = 0; idx < arr.length; idx++) {
            if(prevNum > arr[idx]) {
                isSorted = true;
                break;
            }
        }

        System.out.println("Array is sorted : "+ isSorted);

        // Now Java 8 way :)

        isSorted = false;

        //isSorted = IntStream.of(arr).forEach();
    }
}
