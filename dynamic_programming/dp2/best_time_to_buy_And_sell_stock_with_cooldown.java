package dynamic_programming.dp2;

/* 
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).


Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]

Example 2:

Input: prices = [1]
Output: 0
*/

import java.util.*;

public class best_time_to_buy_And_sell_stock_with_cooldown {

    public static int maxProfit(int[] prices){
        if(prices == null || prices.length <= 1)
            return 0;

        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] cool = new int[n];

        buy[0] = -prices[0];
        sell[0] = 0;
        cool[0] =0;

        for(int i=1; i<n; i++){
            buy[i] = Math.max(buy[i-1], cool[i-1]-prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
            cool[i] = Math.max(cool[i-1], sell[i-1]);
        }

        return Math.max(sell[n-1], cool[n-1]);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] prices = new int[num];
        for(int i=0; i<num; i++){
            prices[i] = sc.nextInt();
        }
        System.out.println(maxProfit(prices));
        sc.close();
    }

}
