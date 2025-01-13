package leetcode.leetcode_36;

import java.util.Set;
import java.util.HashSet;

public class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        // Hash sets to track seen number
        Set<String> seen = new HashSet<>();
        
        // Loop through the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                
                if (num != '.') {
                    // Generate keys for row, column, and sub-box
                    String rowKey = num + " in row " + i;
                    String colKey = num + " in col " + j;
                    String boxKey = num + " in box " + (i / 3) + " - " +  (j / 3);
                    
                    // Check if any key is already in the set
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        
        char[][] board = 
            {{'5','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}};
        
        System.out.println(solution1.isValidSudoku(board));
        
        char[][] board1 = 
            {{'8','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}};
        
        System.out.println(solution1.isValidSudoku(board1));
        
        char[][] board2 = 
            {{'.','.','.','.','5','.','.','1','.'}
            ,{'.','4','.','3','.','.','.','.','.'}
            ,{'.','.','.','.','.','3','.','.','1'}
            ,{'8','.','.','.','.','.','.','2','.'}
            ,{'.','.','2','.','7','.','.','.','.'}
            ,{'.','1','5','.','.','.','.','.','.'}
            ,{'.','.','.','.','.','2','.','.','.'}
            ,{'.','2','.','9','.','.','.','.','.'}
            ,{'.','.','4','.','.','.','.','.','.'}};
        
        System.out.println(solution1.isValidSudoku(board2));
    }
}
