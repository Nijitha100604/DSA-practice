package dynamic_programming.dp2;

/* 

You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.


Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167

Example 2:

Input: nums = [1,5]
Output: 10

*/

import java.util.*;

public class burst_balloons {

    public static int maxCoins(int[] nums){
        int n = nums.length;
        if(n==0)
            return 0;
        int[] extended = new int[n+2];
        extended[0] = 1;
        extended[n+1] = 1;
        for(int i=1; i<=n; i++){
            extended[i] = nums[i-1];
        }

        int[][] dp = new int[n+2][n+2];

        for(int length=1; length<=n; length++){
            for(int left = 1; left <= n-length+1; left++){
                int right = left+length-1;

                for(int i=left; i<=right; i++){
                    int coins = extended[left-1]*extended[i]*extended[right+1];
                    coins += dp[left][i-1] + dp[i+1][right];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }
        return dp[1][n];
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++)
            arr[i] = sc.nextInt();
        System.out.println(maxCoins(arr));
        sc.close();
    }

}
