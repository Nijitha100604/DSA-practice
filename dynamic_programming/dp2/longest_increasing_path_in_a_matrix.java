package dynamic_programming.dp2;

/* 
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).


Example 1:

Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].

Example 2:

Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

Example 3:

Input: matrix = [[1]]
Output: 1
*/

import java.util.*;

public class longest_increasing_path_in_a_matrix {

    public static int longestIncreasingPath(int[][] matrix){
        if(matrix.length == 0)
            return 0;

        int row = matrix.length;
        int col = matrix[0].length;
        int longest = -1;
        int[][] dp = new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                longest = Math.max(longest, dfs(i, j, matrix, dp));
            }
        }
        return longest;
    }

    public static int dfs(int i, int j, int[][] matrix, int[][] dp){
        if(dp[i][j] != 0)
            return dp[i][j];

        int[] rowDir = {-1, 0, 0, 1};
        int[] colDir = {0, -1, 1, 0};
        int max = 1;

        for(int k=0; k<4; k++){
            int r = i + rowDir[k];
            int c = j + colDir[k];

            if(r>=0 && r<matrix.length && c>=0 && c<matrix[0].length && matrix[r][c] > matrix[i][j])
                max = Math.max(max, 1+dfs(r, c, matrix, dp));
        }

        dp[i][j] = max;
        return max;
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

        System.out.println(longestIncreasingPath(matrix));
        sc.close();
    }
}
