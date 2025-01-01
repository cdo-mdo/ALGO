package leetcode.leetcode_6;

public class Solution {
    enum Direction {
        UP,
        DOWN
    }
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        char[][] strs = new char[numRows][s.length()];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                strs[i][j] = ' ';
            }
        }
        Direction dir = Direction.DOWN;
        int col = 0;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.println("row = " + row + " col = " + col);
            strs[row][col] = s.charAt(i);
            if (dir == Direction.DOWN) {
                row++;
                if (row == numRows) {
                    dir = Direction.UP;
                    row -= 2;
                    col++;
                }
            }
            else {
                row--;
                if (row == -1) {
                    dir = Direction.DOWN;
                    row += 2;
                }
                else {
                    col++;
                }
            }
            
            
        }
        
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (strs[i][j] != ' ') {
                    build.append(strs[i][j]);
                }
            }
        }
        
        return build.toString();
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.convert("PAYPALISHIRING", 3));
//        System.out.println(solution.convert("PAYPALISHIRING", 4));
//        System.out.println(solution.convert("A", 1));
        System.out.println(solution.convert("AB", 1));
    }
}
