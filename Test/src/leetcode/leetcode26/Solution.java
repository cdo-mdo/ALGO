package test.leetcode26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        
        int i;
        for (i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i] && nums[j] < min) {
                    min = nums[j];
                }
            }
            if (min == Integer.MAX_VALUE) {
                break;
            }
            nums[i + 1] = min;
        }
        return i + 1;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[] {1, 1, 2}));
        System.out.println(solution.removeDuplicates(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
