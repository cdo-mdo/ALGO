package leetcode.combinationsum;

import java.util.List;
import java.util.ArrayList;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrace(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start) {
        if (target < 0) {
            // Exceed the target, keep exploring
            return;
        }
        if (target == 0) {
            // Found a valid combination
            System.out.println("DEBUG-1 " + "found " + current.toString());
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            System.out.println("DEBUG-0 " + "try " + candidates[i]);
            current.add(candidates[i]); // Choose the current number
            backtrace(result, current, candidates, target - candidates[i], i); // Recur with reduce target (allow reuse)
            int removedItem = current.get(current.size() - 1).intValue();
            System.out.println("DEBUG-0 " + "remove " + removedItem);
            current.remove(current.size() - 1); // Backtrack, remove last added number
        }
    }
    
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[] {2, 3, 5, 7}, 7));
    }
}
