package leetcode.leetcode_48;

public class Solution1 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix.length; j++) {
              System.out.print(matrix[i][j] + " ");
          }
          System.out.println();
        }
        
        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
        
        System.out.println("----------------");
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
          }
    }
    
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        solution1.rorate(matrix);
        
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        solution1.rotate(matrix1);
    }
}
