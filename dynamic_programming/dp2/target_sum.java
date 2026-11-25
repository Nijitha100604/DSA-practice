package dynamic_programming.dp2;

/* 
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.
 

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

Example 2:

Input: nums = [1], target = 1
Output: 1
*/

import java.util.*;

public class target_sum{

    public static int findTargetSumWays(int[] nums, int target){
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for(int num:nums){
            Map<Integer, Integer> tempDp = new HashMap<>();
            for(int key: dp.keySet()){
                int ways = dp.get(key);
                tempDp.put(key+num, tempDp.getOrDefault(key+num, 0)+ways);
                tempDp.put(key-num, tempDp.getOrDefault(key-num, 0)+ways);
            }
            dp = tempDp;
        }
        return dp.getOrDefault(target, 0);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(findTargetSumWays(arr, target));
        sc.close();
    }
}