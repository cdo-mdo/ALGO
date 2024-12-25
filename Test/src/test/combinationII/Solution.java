package test.combinationII;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[candidates.length];
        for (int i = 0; i < candidates.length; i++) {
            nums[i] = candidates[i];
        }
        Arrays.sort(nums);
        
        backtrack(result, new ArrayList<>(), nums, 0, target);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int start, int target) {
        if (target == 0) {
            // found combination
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                // skip duplicates
                continue;
            }
            if (candidates[i] > target) {
                // early stopping since array is sorted
                break;
            }
            current.add(candidates[i]);
            backtrack(result, current, candidates, i + 1, target - candidates[i]);
            current.remove(current.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(new int[] {9, 2, 2, 4, 6, 1, 5}, 8).toString());
    }
}
