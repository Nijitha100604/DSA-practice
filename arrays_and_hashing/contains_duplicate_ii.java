package arrays_and_hashing;

/* 
Given an integer array nums and an integer k, return true if there are two distinct indices i and j such that nums[i] == nums[j] and abs(i - j) <= k, otherwise return false.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false

*/
import java.util.*;

public class contains_duplicate_ii {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(mp.containsKey(nums[i])){
                if(Math.abs(i - mp.get(nums[i])) <= k)
                    return true;
            }
            mp.put(nums[i], i);
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
        int k = sc.nextInt();
        System.out.println(containsNearbyDuplicate(arr, k));
        sc.close();
    }
}
