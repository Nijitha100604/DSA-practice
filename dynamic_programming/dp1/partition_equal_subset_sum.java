package dynamic_programming.dp1;

/* 
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
*/

import java.util.*;

public class partition_equal_subset_sum {

    public static boolean canPartition(int[] nums){
        int totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }
        if(totalSum % 2 != 0)
            return false;

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for(int num: nums){
            for(int j=target; j>=num; j--){
                if(dp[j-num]){
                    dp[j] = dp[j-num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(canPartition(arr));
        sc.close();
    }
}
