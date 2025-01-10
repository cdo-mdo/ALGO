package leetcode.leetcode_15;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return null;
        }
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int k = nums.length - 1;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                System.out.println("i = " + i + " j = " + j);
                for (k = nums.length - 1; k >= j; k--) {
                    if (sum + nums[k] == 0) {
                        List<Integer> element = new ArrayList<>();
                        element.add(nums[i]);
                        element.add(nums[j]);
                        element.add(nums[k]);
                        res.add(element);
                        break;
                    }
                    k--;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
//        System.out.println(solution.threeSum(new int[] {0, 1, 1}));
//        System.out.println(solution.threeSum(new int[] {0, 0, 0}));
//        System.out.println(solution.threeSum(new int[] {0, 0, 0, 0}));
//        System.out.println(solution.threeSum(new int[] {-2, 0, 1, 1, 2}));
//        System.out.println(solution.threeSum(new int[] {-1,0,1,2,-1,-4,-2,-3,3,0,4}));
    }
}
