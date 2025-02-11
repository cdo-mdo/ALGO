package leetcode.leetcode_73;

import java.util.Set;
import java.util.HashSet;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> skip = new HashSet<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!skip.contains(i*n + j)) {
                    if (matrix[i][j] == 0) {
                        // Set all row and column to zero
                        for (int k = 0; k < n; k++) {
                            if ((matrix[i][k]) != 0) {
                                matrix[i][k] = 0;
                                skip.add(i*n + k);
                            }
                        }
                        for (int k = 0; k < m; k++) {
                            if (matrix[k][j] != 0) {
                                matrix[k][j] = 0;
                                skip.add(k*n + j);
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println("----------------");
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        solution.setZeroes(new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        solution.setZeroes(new int[][] {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
        
        solution.setZeroes(new int[][] {{0,9,3,3,8,2,1,4,1,7,1,2,7},
                                        {6,0,2,3,3,8,5,1,9,3,2,0,7},
                                        {8,4,6,0,2,6,1,5,1,0,7,2,6},
                                        {1,1,9,3,9,6,5,1,1,1,1,7,2},
                                        {0,0,6,3,9,4,7,5,6,0,3,7,7},
                                        {5,9,7,9,6,8,1,5,3,0,3,8,3},
                                        {5,1,7,4,3,9,4,9,2,6,5,0,3}});
    }
}
