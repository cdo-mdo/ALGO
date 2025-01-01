package leetcode.subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // start with an empty subset
        res.add(new ArrayList<>());
        System.out.println("DEBUG-0 " + res.toString());
        for (int num: nums) {
            int size = res.size();
            System.out.println("DEBUG-2 size = " + size);
            for (int i = 0; i < size; i++) {
                System.out.println("DEBUG-3 size = " + size);
                List<Integer> newSubset = new ArrayList<>(res.get(i));
                newSubset.add(num);
                res.add(newSubset);
                System.out.println("DEBUG-1 num = " + num + " " + res.toString());
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[] {1, 2, 3}).toString());
    }
}
