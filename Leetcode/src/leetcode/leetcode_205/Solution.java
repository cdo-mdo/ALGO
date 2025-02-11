package leetcode.leetcode_205;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        Map<Character, Character> mapForward = new HashMap<>();
        Map<Character, Character> mapBackward = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (mapForward.containsKey(c1) && mapForward.get(c1) != c2) {
                return false;
            }
            else {
                mapForward.put(c1, c2);
            }
            if (mapBackward.containsKey(c2) && mapBackward.get(c2) != c1) {
                return false;
            }
            else {
                mapBackward.put(c2, c1);
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        System.out.println(solution.isIsomorphic("egg", "add"));
        System.out.println(solution.isIsomorphic("foo", "bar"));
        System.out.println(solution.isIsomorphic("paper", "title"));
        System.out.println(solution.isIsomorphic("badc", "baba"));
        
    }
}
