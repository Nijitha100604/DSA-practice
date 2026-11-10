package arrays_and_hashing;

/* 
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
*/

import java.util.*;

public class product_except_self {

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] lp = new int[nums.length];
        lp[0] = 1;
        int[] rp = new int[nums.length];
        rp[nums.length - 1] = 1;

        for(int i=1; i<nums.length; i++){
            lp[i] = lp[i-1]*nums[i-1];
        }
        for(int i=nums.length-2; i>=0; i--){
            rp[i] = rp[i+1]*nums[i+1];
        }
        for(int i=0; i<nums.length; i++){
            result[i] = lp[i]*rp[i];
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int count = 0; count < num; count++){
            int value = sc.nextInt();
            arr[count] = value;
        }
        System.out.println(productExceptSelf(arr));
        sc.close();
    }
}
