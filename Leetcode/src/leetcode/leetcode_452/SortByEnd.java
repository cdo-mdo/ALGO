package leetcode.leetcode_452;

import java.util.Arrays;

public class SortByEnd {
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        
        // Print the original array
        for (int[] point: points) {
            System.out.print(Arrays.toString(point) + " ");
        }
        System.out.println();
        
        // Sort by the end value of the intervals
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        // Print the sorted array to verify
        for (int[] point: points) {
            System.out.print(Arrays.toString(point) + " ");
        }
    }
}
