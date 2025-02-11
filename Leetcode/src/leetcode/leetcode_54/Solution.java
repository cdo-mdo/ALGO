package leetcode.leetcode_54;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();
        
        while (left <= right && top <= bottom) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            ++top; // Move the top boundary down
            
            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            --right; // Move the right boundary left
            
            // Traverse from right to left if there is a remaining row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                --bottom; // Move the bottom boundary up
            }
            
            // Traverse from bottom to top, if there is a remaining column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                ++left; // Move the left boundary right
            }
            
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        System.out.println(solution.spiralOrder(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(solution.spiralOrder(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        
    }
}
