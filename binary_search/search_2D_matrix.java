package binary_search;

/* 
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.


Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
*/

import java.util.*;

public class search_2D_matrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int idx = searchPotentialRow(matrix, target);
        if(idx == -1) return false;
        return searchByRow(idx, matrix, target);
    }

    public static int searchPotentialRow(int[][] matrix, int target){
        int low = 0;
        int high = matrix.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1])
                return mid;
            else if(matrix[mid][0] < target)
                low = mid+1;
            else if(matrix[mid][0] > target)
                high = mid-1;
        }
        return -1;
    }

    public static boolean searchByRow(int idx, int[][] matrix, int target){
        int low = 0;
        int high = matrix[idx].length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(matrix[idx][mid] == target)  
                return true;
            else if(matrix[idx][mid] < target)
                low = mid + 1;
            else if(matrix[idx][mid] > target)
                high = mid - 1; 
        }

        return false;
        
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int target = sc.nextInt();
        System.out.println(searchMatrix(matrix, target));
        sc.close();
    }
}
