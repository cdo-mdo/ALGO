package leetcode.leetcode_76;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
                
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character chr = t.charAt(i);
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }
        
        int left = 0;
        // Begin at the position of character that can be found in string t
        for (left = 0; left < s.length(); left++) {
            if (map.containsKey(s.charAt(left))) {
                break;
            }
        }
        
        // Not found any character in string s also found in string t
        if (left >= s.length()) {
            return "";
        }
        
        int right = left + 1;
        int count = 1;
        int len = Integer.MAX_VALUE;
        Map<Integer, Integer> posMap = new HashMap<>();
        if (count == t.length()) {
            posMap.put(right - left, left);
            len = Math.min(len, right - left);
        }
        Map<Character, Integer> currentMap = new HashMap<>();
        while (right < s.length()) {
            Character chr = s.charAt(right);
            right++;
            if (map.containsKey(chr)) {
                currentMap.put(chr, currentMap.getOrDefault(chr, 0) + 1);
                if (currentMap.get(chr) <= map.get(chr)) {
                    count++;
                }
                if (count == t.length()) {
                    posMap.put(right - left, left);
                    len = Math.min(len, right - left);
                    while (left < right) {
                        left++;
                        if (map.containsKey(s.charAt(left))) {
                            currentMap.put(s.charAt(left), currentMap.get(s.charAt(left)) - 1);
                            count--;
                            break;
                        }
                    }
                }
            }
        }
//        System.out.println("left = " + posMap.get(len) + " len = " + len);
        
        return len == Integer.MAX_VALUE? "":s.substring(posMap.get(len), posMap.get(len) + len);
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
//        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(solution.minWindow("a", "a"));
//        System.out.println(solution.minWindow("a", "aa"));
//        System.out.println(solution.minWindow("ab", "a"));
//        System.out.println(solution.minWindow("ab", "A"));
//        System.out.println(solution.minWindow("abc", "cba"));
        System.out.println(solution.minWindow("acbbaca", "aba"));
        
    }
}
