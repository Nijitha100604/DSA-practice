package arrays_and_hashing;

/* 
Given a 9x9 Sudoku board, determine if it is valid. Only the filled cells need to be validated according to the following rules:
1. Each row must contain the digits 1-9 without repetition.
2. Each column must contain the digits 1-9 without repetition.
3. Each of the nine 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:
Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."],
[".","9","8",".",".",".",".","6","."],
["8",".",".",".","6",".",".",".","3"],
["4",".",".","8",".","3",".",".","1"],
["7",".",".",".","2",".",".",".","6"],
[".","6",".",".",".",".","2","8","."],
[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:
Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."],
[".","9","8",".",".",".",".","6","."],
["8",".",".",".","6",".",".",".","3"],
["4",".",".","8",".","3",".",".","1"],
["7",".",".",".","2",".",".",".","6"],
[".","6",".",".",".",".","2","8","."],
[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]]
Output: false


*/

import java.util.*;

public class valid_sudoku {

    public static boolean isValidSudoku(char[][] board) {
        int N = 9;
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];

        for(int i=0; i<9; i++){
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char val = board[i][j];
                if(val == '.')
                    continue;
                
                if(rows[i].contains(val))
                    return false;
                rows[i].add(val);

                if(cols[j].contains(val))
                    return false;
                cols[j].add(val);

                int idx = (i/3)*3 + j/3;
                if(boxes[idx].contains(val))
                    return false;
                boxes[idx].add(val);
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                board[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println(isValidSudoku(board));
        sc.close();
    }
}
