package two_pointers_and_sliding_window;

/* 
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
*/

import java.util.*;

public class trapping_rain_water {

    public static int trap(int[] height){
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int max = -1;

        for(int i=0; i<height.length; i++){
            if(height[i] >= max)
                max = height[i];
            leftMax[i] = max;
        }

        max = -1;
        for(int i = height.length - 1; i>=0; i--){
            if(height[i] >= max)
                max = height[i];
            rightMax[i] = max;
        }

        int total = 0;
        for(int i=0; i<height.length; i++){
            total += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return total;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(trap(arr));
        sc.close();
    }
}
