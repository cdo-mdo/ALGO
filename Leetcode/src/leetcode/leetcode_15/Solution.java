package leetcode.leetcode_15;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return null;
        }
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        while (left < right - 1) {
            int sum = nums[left] + nums[right];
            for (int i = left + 1; i < right; i++) {
                if (sum + nums[i] == 0) {
                    List<Integer> element = new ArrayList<>();
                    element.add(nums[left]);
                    element.add(nums[i]);
                    element.add(nums[right]);
                    res.add(element);
                    break;
                }
            }
            while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
                left++;
            }
            while (right > 0 && nums[right] == nums[right - 1]) {
                right--;
            }
            if (left >= right - 1) {
                break;
            }
            if (sum == 0) {
                if ((nums[left + 1] - nums[left]) > (nums[right] - nums[right - 1])) {
                    right--;
                }
                else {
                    left++;
                }
            }
            else if (sum > 0) {
                right--;
            }
            else {
                left++;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
//        System.out.println(solution.threeSum(new int[] {0, 1, 1}));
//        System.out.println(solution.threeSum(new int[] {0, 0, 0}));
//        System.out.println(solution.threeSum(new int[] {0, 0, 0, 0}));
//        System.out.println(solution.threeSum(new int[] {-2, 0, 1, 1, 2}));
        System.out.println(solution.threeSum(new int[] {-1,0,1,2,-1,-4,-2,-3,3,0,4}));
    }
}
