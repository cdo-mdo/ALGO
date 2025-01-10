package leetcode.leetcode_53;

public class Solution1 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution1.maxSubArray(new int[] {1}));
        System.out.println(solution1.maxSubArray(new int[] {5, 4, -1, 7, 8}));
    }
}
