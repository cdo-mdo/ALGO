package test.leetcode_42;

import java.util.Arrays;

public class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            // less than 3 cannot trap water
            return 0;
        }
        int water = 0;
        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                }
                else {
                    water += left_max - height[left];
                }
                left++;
            }
            else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                }
                else {
                    water += right_max - height[right];
                }
                right--;
            }
        }
        return water;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(solution.trap(new int[] {4, 2, 0, 3, 2, 5}));
    }
}
