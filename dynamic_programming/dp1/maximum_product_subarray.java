package dynamic_programming.dp1;

/* 
Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Note that the product of an array with a single element is the value of that element.

​​​​​​​Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

import java.util.*;

public class maximum_product_subarray {

    public static int maxProduct(int[] nums){
        int leftProduct = 1;
        int rightProduct = 1;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct *= nums[i];
            rightProduct *= nums[nums.length - i - 1];

            max = Math.max(max, Math.max(leftProduct, rightProduct));
        }
        return max;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxProduct(arr));
        sc.close();
    }
}
