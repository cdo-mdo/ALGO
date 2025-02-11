package leetcode.leetcode_452;

import java.util.Arrays;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        
        // Sort the array of interval by ending points
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 0;
        long end = (long) Integer.MIN_VALUE - 1;
        
        for (int[] point : points) {
            if (point[0] > end) {
                arrows++;
                end = point[1];
            }
        }
        return arrows;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinArrowShots(new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println(solution.findMinArrowShots(new int[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(solution.findMinArrowShots(new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
        System.out.println(solution.findMinArrowShots(new int[][] {{-2147483648, 2147483647}}));
    }
}
