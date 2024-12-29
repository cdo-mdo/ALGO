package test.leetcode_169;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int num: nums) {
            if (maps.containsKey(num)) {
                Integer value = maps.get(num);
                maps.put(num, ++value);
            }
            else {
                maps.put(num, 1);
            }
        }
        int n = nums.length/2;
        int max = 0;
        int res = 0;
        for (Integer key: maps.keySet()) {
            Integer value = maps.get(key);
            if (value > max && value > n) {
                max = value;
                res = key;
            }
        }
                
        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[] {3, 2, 3}));
        System.out.println(solution.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
    }
}
