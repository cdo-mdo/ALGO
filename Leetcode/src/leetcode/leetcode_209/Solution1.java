package leetcode.leetcode_209;

public class Solution1 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums[0] >= target) {
            return 1;
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        for (end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                len = Math.min(end - start + 1, len);
                sum -= nums[start];
                start++;
            }
        }
        
        return len == Integer.MAX_VALUE? 0: len;
    }
    
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
        System.out.println(solution1.minSubArrayLen(4, new int[] {1, 4, 4}));
        System.out.println(solution1.minSubArrayLen(11, new int[] {1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
