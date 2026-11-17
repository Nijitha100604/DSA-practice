package math_and_geometry;

/* 
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

import java.util.*;

public class spiral_matrix {

    public static List<Integer> spiralOrder(int[][] matrix){
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        List<Integer> ans = new ArrayList<>();

        while(top <= bottom && left <= right){

            // left to right
            for(int i=left; i<=right; i++)
                ans.add(matrix[top][i]);
            top++;

            // top to bottom
            for(int i=top; i<=bottom; i++)
                ans.add(matrix[i][right]);
            right--;

            // right to left
            if(top <= bottom){
                for(int i=right; i>=left; i--)
                    ans.add(matrix[bottom][i]);
                bottom--;
            }

            // bottom to top
            if(left <= right){
                for(int i=bottom; i>=top; i--)
                    ans.add(matrix[i][left]);
                left++;
            }
        }

        return ans;
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
        System.out.println(spiralOrder(matrix));
        sc.close();
    }
}
