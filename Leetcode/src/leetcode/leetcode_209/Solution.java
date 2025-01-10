package leetcode.leetcode_209;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int j = i;
            for (j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    break;
                }
            }
            if (sum >= target) {
                len = Math.min(len, j - i + 1);
            }
        }
        return len == Integer.MAX_VALUE? 0: len;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
        System.out.println(solution.minSubArrayLen(4, new int[] {1, 4, 4}));
        System.out.println(solution.minSubArrayLen(11, new int[] {1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
