package leetcode.leetcode_36;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<List<Cell>> rows = new ArrayList<>(board.length);
        List<List<Cell>> cols = new ArrayList<>(board.length);
        List<List<Cell>> blocks = new ArrayList<>(board.length);
        
        // Build map for rows and columns
        for (int i = 0; i < board.length; i++) {
            List<Cell> row = new ArrayList<>();
            List<Cell> col = new ArrayList<>();
            for (int j = 0; j < board.length; j++) {
                row.add(new Cell(i, j));
                col.add(new Cell(j, i));
            }
            rows.add(row);
            cols.add(col);
        }
        
        // Build map for blocks
        List<Cell> block1 = new ArrayList<>();
        List<Cell> block2 = new ArrayList<>();
        List<Cell> block3 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < board.length; j++) {
                if (j < 3) {
                    block1.add(new Cell(i, j));
                }
                else if (j < 6) {
                    block2.add(new Cell(i, j));
                }
                else {
                    block3.add(new Cell(i, j));
                }
            }
        }
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);
        

        List<Cell> block4 = new ArrayList<>();
        List<Cell> block5 = new ArrayList<>();
        List<Cell> block6 = new ArrayList<>();
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < board.length; j++) {
                if (j < 3) {
                    
                    block4.add(new Cell(i, j));
                }
                else if (j < 6) {
                    
                    block5.add(new Cell(i, j));
                }
                else {
                    
                    block6.add(new Cell(i, j));
                }
            }
        }
        blocks.add(block4);
        blocks.add(block5);
        blocks.add(block6);

        List<Cell> block7 = new ArrayList<>();
        List<Cell> block8 = new ArrayList<>();
        List<Cell> block9 = new ArrayList<>();
        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < board.length; j++) {
                if (j < 3) {
                    
                    block7.add(new Cell(i, j));
                }
                else if (j < 6) {
                    
                    block8.add(new Cell(i, j));
                }
                else {
                    
                    block9.add(new Cell(i, j));
                }
            }
        }
        blocks.add(block7);
        blocks.add(block8);
        blocks.add(block9);

        // Verify
        for (List<Cell> row: rows) {
            int[] check = new int[9];
            row.forEach( c -> {
                if (board[c.row][c.col] != '.') {
                    check[board[c.row][c.col] - '1']++;
                }
            });
            for (int n : check) {
                if (n > 1) {
                    return false;
                }
            }
        }
        
        for (List<Cell> col: cols) {
            int[] check = new int[9];
            col.forEach( c -> {
                if (board[c.row][c.col] != '.') {
                    check[board[c.row][c.col] - '1']++;
                }
            });
            for (int n : check) {
                if (n > 1) {
                    return false;
                }
            }
        }
        
        for (List<Cell> block: blocks) {
            int[] check = new int[9];
            block.forEach( c -> {
                if (board[c.row][c.col] != '.') {
                    check[board[c.row][c.col] - '1']++;
                }
            });
            for (int n : check) {
                if (n > 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    class Cell {
        int row;
        int col;
        
        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        public String toString() {
            return "[" + row + ", " + col + "]";
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
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
        
        System.out.println(solution.isValidSudoku(board));
        
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
        
        System.out.println(solution.isValidSudoku(board1));
        
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
        
        System.out.println(solution.isValidSudoku(board2));
    }
}
