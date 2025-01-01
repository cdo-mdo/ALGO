package leetcode.subsetsII;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedNums[i] = nums[i];
        }
        Arrays.sort(sortedNums);
        
        int start = 0;
        int end = 0;
        for (int i = 0; i < sortedNums.length; i++) {
            start = 0;
            // If current number is same as previous, only use subsets
            // generated from the last step to avoid duplicates
            if (i > 0 && sortedNums[i] == sortedNums[i - 1]) {
                start = end + 1;
            }
            end = result.size() - 1;
            
            // Add the current number to all existing number
            int size = result.size();
            for (int j = start; j < size; j++) {
                List<Integer> newSubset = new ArrayList<>(result.get(j));
                newSubset.add(sortedNums[i]);
                result.add(newSubset);
            }
        }
        
        return result;
    }
    
    
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsetsWithDup(new int[] {1, 2, 1}));
    }
}
