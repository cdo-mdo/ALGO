package test.leetcode_238;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = product/nums[i];
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.productExceptSelf(new int[] {1, 2, 3, 4});
        System.out.println(Arrays.toString(res));
    }
}
