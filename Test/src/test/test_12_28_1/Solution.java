package test.test_12_28_1;

public class Solution {
    public int minimumOperations(int[][] grid) {
        int columns = grid[0].length;
        
        int res = 0;
        for (int i = 0; i < columns; i++) {
            for (int j = 1; j < grid.length; j++) {
                if (grid[j][i] <= grid[j - 1][i]) {
                    res += grid[j - 1][i] + 1 - grid[j][i];
                    grid[j][i] = grid[j - 1][i] + 1;
                }
            }
        }
        
        return res;
        
    }
}
