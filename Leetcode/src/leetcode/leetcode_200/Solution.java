package leetcode.leetcode_200;

public class Solution {
    char[][] grid = null;
    
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null) {
            return 0;
        }
        this.grid = grid;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    
                    // explore neighbor cells
                    explore(this.grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void explore(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length) {
            return;
        }
        if (j < 0 || j < grid.length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        explore(this.grid, i - 1, j);
        explore(this.grid, i, j + 1);
        explore(this.grid, i + 1, j);
        explore(this.grid, i, j - 1);
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        
        System.out.println(solution.numIslands(grid));
    }
}
