package leetcode.leetcode_15;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return null;
        }
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> elem = new ArrayList<>();
                    elem.add(nums[i]);
                    elem.add(nums[left]);
                    elem.add(nums[right]);
                    res.add(elem);
                    
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        
        return res;
        
    }
    
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
        System.out.println(solution2.threeSum(new int[] {0, 1, 1}));
        System.out.println(solution2.threeSum(new int[] {0, 0, 0}));
        System.out.println(solution2.threeSum(new int[] {0, 0, 0, 0}));
        System.out.println(solution2.threeSum(new int[] {-2, 0, 1, 1, 2}));
        System.out.println(solution2.threeSum(new int[] {-1,0,1,2,-1,-4,-2,-3,3,0,4}));
    }
}
