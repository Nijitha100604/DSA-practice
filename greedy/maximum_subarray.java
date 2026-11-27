package greedy;

/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23. 
*/

import java.util.*;

public class maximum_subarray {

    public static int maxSubArray(int[] nums){
        int max = nums[0];
        int curr_sum = nums[0];

        for(int i=1; i<nums.length; i++){
            curr_sum = Math.max(curr_sum+nums[i], curr_sum);
            max = Math.max(max, curr_sum);
        }

        return max;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++)
            arr[i] = sc.nextInt();
        System.out.println(maxSubArray(arr));
        sc.close();
    }
}
