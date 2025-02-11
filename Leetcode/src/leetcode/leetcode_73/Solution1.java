package leetcode.leetcode_73;

public class Solution1 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            rows[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            cols[i] = 1;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    System.out.println("set row = " + i + " column = " + j + " to 0");
                    rows[i] = 0;
                    cols[j] = 0;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            if (rows[i] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (cols[i] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
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
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        
        solution1.setZeroes(new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        solution1.setZeroes(new int[][] {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
        
        solution1.setZeroes(new int[][] {{0,9,3,3,8,2,1,4,1,7,1,2,7},
                                        {6,0,2,3,3,8,5,1,9,3,2,0,7},
                                        {8,4,6,0,2,6,1,5,1,0,7,2,6},
                                        {1,1,9,3,9,6,5,1,1,1,1,7,2},
                                        {0,0,6,3,9,4,7,5,6,0,3,7,7},
                                        {5,9,7,9,6,8,1,5,3,0,3,8,3},
                                        {5,1,7,4,3,9,4,9,2,6,5,0,3}});
    }
}
