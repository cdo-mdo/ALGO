package leetcode.leetcode_228;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        
        int left = 0;
        int right = left + 1;
        while (right <= nums.length) {
            if ((right == nums.length) || (nums[right] > nums[right - 1] + 1))  {
                // put this range to return list, and start checking new range
                if (nums[left] == nums[right - 1]) {
                    res.add("" + nums[left]);
                }
                else {
                    res.add(nums[left] + "->" + nums[right - 1]);
                }
                left = right;
            }
            right++;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.summaryRanges(new int[] {0, 1, 2, 4, 5, 7}));
        System.out.println(solution.summaryRanges(new int[] {0, 2, 3, 4, 6, 8, 9}));
    }
}
