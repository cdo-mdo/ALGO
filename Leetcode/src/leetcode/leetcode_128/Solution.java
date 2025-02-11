package leetcode.leetcode_128;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int longestStreak = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int currentNum = iterator.next();
            if (!set.contains(currentNum - 1)) {
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentStreak++;
                    currentNum++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
        System.out.println(solution.longestConsecutive(new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
