package leetcode.leetcode_238;

import java.util.Arrays;

public class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.productExceptSelf(new int[] {1, 2, 3, 4});
        System.out.println(Arrays.toString(res));
    }
}
