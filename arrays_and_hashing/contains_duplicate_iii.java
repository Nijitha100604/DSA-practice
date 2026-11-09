package arrays_and_hashing;

/*
Given an integer array nums and two integers indexDiff and valueDiff, find if there exist two indices i and j such that:
1. 0 <= i < j < nums.length
2. abs(i - j) <= indexDiff
3. abs(nums[i] - nums[j]) <= valueDiff

Example 1:
Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
Output: true

Example 2:
Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
Output: false
*/

import java.util.*;

public class contains_duplicate_iii {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            long num = nums[i];
            if(i > indexDiff){
                set.remove((long)nums[i-indexDiff-1]);
            }
            Long value = set.ceiling(num - valueDiff);
            if (value != null && value <= num + valueDiff) {
                return true;
            }
            set.add(num);
        } 
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++){
            int value = sc.nextInt();
            arr[i] = value;
        }
        int indexDiff = sc.nextInt();
        int valueDiff = sc.nextInt();
        System.out.println(containsNearbyAlmostDuplicate(arr, indexDiff, valueDiff));
        sc.close();
    }
}
