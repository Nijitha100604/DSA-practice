package arrays_and_hashing;
/* 
Given an integer array nums and an integer k, return the total number of subarrays whose sum equals to k.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2
*/

import java.util.*;

public class subarray_sum_equals_k {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int count = 0;
        int sum = 0;
        mp.put(0, 1);
        for(int i=0; i< nums.length; i++){
            sum += nums[i];
            int value = sum - k;
            if(mp.containsKey(value)){
                count += mp.get(value);
            }
            mp.put(sum, mp.getOrDefault(sum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int count = 0; count < num; count++){
            arr[count] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(subarraySum(arr, k));
        sc.close();
    }
}
