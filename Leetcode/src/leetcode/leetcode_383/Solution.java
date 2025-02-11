package leetcode.leetcode_383;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (char c: ransomNote.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            else {
                if (map.get(c) <= 0) {
                    return false;
                }
                else {
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("a", "b"));
        System.out.println(solution.canConstruct("aa", "ab"));
        System.out.println(solution.canConstruct("aa", "aab"));
    }
}
