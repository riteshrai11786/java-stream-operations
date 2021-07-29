package com.ritesh.testcodes;

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

/*class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends*/


class Solution
{

    public static void main(String[] args) {

        int [] m = {1,2,3,7,5};
        int n = 5;
        int s = 12;
        ArrayList<Integer> res = subarraySum(m, n, s);
        for(int ii = 0;ii<res.size();ii++)
            System.out.print(res.get(ii) + " ");
        System.out.println();
    }
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        // Your code here
        int curr_sum = arr[0];
        int start_idx = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 1; i <= n; i ++){

            // If the current sum is greater than given sum
            // move start only it is possible
            while(curr_sum > s && start_idx < i - 1) {
                curr_sum = curr_sum - arr[start_idx];
                start_idx++;
            }

            if(curr_sum == s) {
                //int p = i - 1;

                /*for(int idx = start_idx; idx <= p; idx++){
                    result.add(arr[idx]);
                }*/
                result.add(++start_idx);
                result.add(i);

                return result;
            }

            if(i<n)
                curr_sum = arr[i] + curr_sum;
        }
        System.out.println("No subarray found");
        return result;
    }
}