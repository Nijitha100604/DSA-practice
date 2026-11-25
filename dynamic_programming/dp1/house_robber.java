package dynamic_programming.dp1;

/* 
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.


Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
*/

import java.util.*;

public class house_robber {

    public static int rob(int[] nums){
        if(nums.length == 1)
            return nums[0];

        int[] totalLoot = new int[nums.length];
        totalLoot[0] = nums[0];
        totalLoot[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            totalLoot[i] = Math.max(nums[i] + totalLoot[i-2], totalLoot[i-1]);
        }
        return totalLoot[nums.length - 1];
    }

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(rob(arr));
        sc.close();
        
    }
}
