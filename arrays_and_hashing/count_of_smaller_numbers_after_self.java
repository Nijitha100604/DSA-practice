package arrays_and_hashing;

/* 

Given an integer array nums, return the number of elements that have a smaller element to their right. 

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

Example 2:

Input: nums = [-1]
Output: [0]

Example 3:

Input: nums = [-1,-1]
Output: [0,0]
*/

import java.util.*;

public class count_of_smaller_numbers_after_self {
    
    static int[] count;
    static int[] indices;
    static int[] temp;

    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        indices = new int[n];
        count = new int[n];
        temp = new int[n];

        for(int i=0; i<n; i++){
            indices[i] = i;
        }
        
        mergeSort(nums, 0, n-1);

        List<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            result.add(count[i]);
        }

        return result;
    }

    public static void mergeSort(int[] nums, int low, int high){
        if(low >= high)
            return;
        
        int mid = low + (high - low)/2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);

        merge(nums, low, mid, high);
    }

    public static void merge(int[] nums, int low, int mid, int high){
        int l = low;
        int r = mid + 1;
        int t = low;

        while(l <= mid && r <= high){

            if(nums[indices[l]] <= nums[indices[r]]){
                count[indices[l]] += r - (mid + 1);
                temp[t] = indices[l];
                l++; 
            } else{
                temp[t] = indices[r];
                r++;
            }
            t++;
        }
        while(l <= mid){
            count[indices[l]] += r - (mid + 1);
            temp[t] = indices[l];
            l++;
            t++;
        }
        while(r <= high){
            temp[t] = indices[r];
            r++;
            t++;
        }

        for(int i = low; i <= high; i++){
            indices[i] = temp[i];
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
        }
        List<Integer>result = countSmaller(arr);
        System.out.println(result);
        sc.close();
    }
    
}