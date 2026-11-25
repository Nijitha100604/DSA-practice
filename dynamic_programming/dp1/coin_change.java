package dynamic_programming.dp1;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Example 3:

Input: coins = [1], amount = 0
Output: 0 
*/

import java.util.*;

public class coin_change {

    public static int coinChange(int[] coins, int amount){
        if(amount < 1)
            return 0;

        int[] minCoins = new int[amount+1];
        for(int i=1; i<=amount; i++){
            minCoins[i] = Integer.MAX_VALUE;
            
            for(int coin: coins){
                if(coin <= i && minCoins[i-coin] != Integer.MAX_VALUE)
                    minCoins[i] = Math.min(minCoins[i], minCoins[i-coin]+1);
            }
        }

        if(minCoins[amount] == Integer.MAX_VALUE)
            return -1;
        return minCoins[amount];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        System.out.println(coinChange(arr, amount));
        sc.close();
    }
}
