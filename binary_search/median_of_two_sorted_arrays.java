package binary_search;

/* 

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).
 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

*/

import java.util.*;

public class median_of_two_sorted_arrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] smaller = nums1.length <= nums2.length ? nums1 : nums2;
        int[] larger = nums1.length > nums2.length ? nums1 : nums2;

        int totalLength = smaller.length + larger.length;

        int left = 0;
        int right = smaller.length;

        while(left <= right){
            int partitionX = (left + right) / 2;
            int partitionY = (totalLength + 1)/2 - partitionX;

            int l1 = partitionX == 0 ? Integer.MIN_VALUE : smaller[partitionX - 1];
            int r1 = partitionX == smaller.length ? Integer.MAX_VALUE : smaller[partitionX];
            int l2 = partitionY == 0 ? Integer.MIN_VALUE : larger[partitionY - 1];
            int r2 = partitionY == larger.length ? Integer.MAX_VALUE : larger[partitionY];

            if(l1 <= r2 && l2 <= r1){
                if(totalLength % 2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                }
                return Math.max(l1, l2);
            }

            if(l1 > r2)
                right = partitionX - 1;
            else
                left = partitionX + 1;
        }

        return 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int[] arr1 = new int[num1];
        int[] arr2 = new int[num2];

        for(int i=0; i<num1; i++){
            arr1[i] = sc.nextInt();
        }

        for(int i=0; i<num2; i++){
            arr2[i] = sc.nextInt();
        }

        System.out.println(findMedianSortedArrays(arr1, arr2));
        sc.close();
    }
}
