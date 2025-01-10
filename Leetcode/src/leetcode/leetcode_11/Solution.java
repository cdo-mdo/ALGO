package leetcode.leetcode_11;

public class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            area = Math.max(area, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return area;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(solution.maxArea(new int[] {1, 1}));
    }
}
