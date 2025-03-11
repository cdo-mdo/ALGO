package leetcode.leetcode_200;

public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null) {
            return 0;
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    
                    // explore neighbor cells
                    explore(grid, i - 1, j);
                    explore(grid, i + 1, j);
                    explore(grid, i, j - 1);
                    explore(grid, i, j + 1);
                }
            }
        }
        
        return count;
    }
    
    private void explore(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return;
        }
        if (j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            explore(grid, i - 1, j);
            explore(grid, i, j + 1);
            explore(grid, i + 1, j);
            explore(grid, i, j - 1);
        }
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
