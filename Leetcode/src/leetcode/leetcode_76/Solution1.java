package leetcode.leetcode_76;

import java.util.Map;
import java.util.HashMap;

public class Solution1 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        
        // Count the character in t
        Map<Character, Integer> required = new HashMap<>();
        for (char c: t.toCharArray()) {
            required.put(c, required.getOrDefault(c, 0) + 1);
        }
        
        // Sliding window variables
        int left = 0, right = 0;
        int requiredCount = required.size();
        int formed = 0; // Tracks how many unique characters have met their count in t
        Map<Character, Integer> windowCounts = new HashMap<>();
        
        // Result variable
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        
        while (right < s.length()) {
            // expand the window
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
            
            if (required.containsKey(c) && windowCounts.get(c).equals(required.get(c))) {
                formed++;
            }
            
            // Contract the window from the left
            while (left <= right && formed == requiredCount) {
                c = s.charAt(left);
                
                // Update the result if this window  is smaller
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }
                
                // Remove the left character from the window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (required.containsKey(c) && windowCounts.get(c) < required.get(c)) {
                    formed--;
                }
                left++;
            }
            
            right++;
        }
        
        return minLength == Integer.MAX_VALUE ? "": s.substring(start, start + minLength);
    }
    
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        
        System.out.println(solution1.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution1.minWindow("a", "a"));
        System.out.println(solution1.minWindow("a", "aa"));
        System.out.println(solution1.minWindow("ab", "a"));
        System.out.println(solution1.minWindow("ab", "A"));
        System.out.println(solution1.minWindow("abc", "cba"));
        System.out.println(solution1.minWindow("acbbaca", "aba"));
        
    }
}
