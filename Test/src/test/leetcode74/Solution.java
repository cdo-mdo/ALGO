package test.leetcode74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int start = 0;
        int end = rowNum*colNum - 1;
        while (start <= end) {
            int middle = (start + end)/2;
            int row = middle / colNum;
            int col = middle % colNum;
//            System.out.println("start = " + start + " end = " + end + " middle = " + middle + " row = " + row + " column = " + col);
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7},
                          {10, 11, 16, 20},
                          {23, 30, 34, 60}};
        int[][] matrix1 = {{1, 3}};
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(matrix, 3));
        System.out.println(solution.searchMatrix(matrix, 13));
        System.out.println(solution.searchMatrix(matrix, 5));
        System.out.println(solution.searchMatrix(matrix1, 3));
    }
}
