package stack;

/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
*/

import java.util.*;

public class daily_temperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i=n-1; i>=0; i--){

            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()])
                stack.pop();

            if(!stack.isEmpty() && temperatures[i] < temperatures[stack.peek()])
                result[i] = stack.peek() - i;

            if(stack.isEmpty())
                result[i] = 0;
            
            stack.push(i);
        }
        return result;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(dailyTemperatures(arr));
        sc.close();
    }
}
