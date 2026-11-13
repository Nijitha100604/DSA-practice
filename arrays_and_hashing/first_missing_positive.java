package arrays_and_hashing;

/* 
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.

Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.

Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
*/

import java.util.*;

public class first_missing_positive {

    public static int firstMissingPositive(int[] nums){
        for(int i=0; i<nums.length; i++){
            if(nums[i] <=0 || nums[i] > nums.length)
                nums[i] = nums.length + 1;
        }

        for(int i=0; i<nums.length; i++){
            int num = Math.abs(nums[i]);
            if(num > nums.length)
                continue;
            if(nums[num-1] > 0)
                nums[num-1] = -nums[num-1];
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0)
                return i+1;
        }
        return nums.length + 1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int count = 0; count < num; count++){
            arr[count] = sc.nextInt();
        }
        System.out.println(firstMissingPositive(arr));
        sc.close();
    }
}
