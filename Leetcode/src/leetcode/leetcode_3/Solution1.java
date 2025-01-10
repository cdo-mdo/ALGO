package leetcode.leetcode_3;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int start = 0;
        int end;
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(start), start);
        for (end = 1; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                len = Math.max(end - start, len);
                int duplicatePos = map.get(s.charAt(end));
                for (int i = start; i <= duplicatePos; i++) {
                    map.remove(s.charAt(i));
                }
                start = duplicatePos + 1;
                if (start >= s.length()) {
                    break;
                }
                map.put(s.charAt(start), start);
            }
            map.put(s.charAt(end), end);
        }
        len = Math.max(end - start, len);
        return len;
    }
    
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution1.lengthOfLongestSubstring("bbbb"));
        System.out.println(solution1.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution1.lengthOfLongestSubstring("au"));
        System.out.println(solution1.lengthOfLongestSubstring("abba"));
        System.out.println(solution1.lengthOfLongestSubstring("aab"));
    }
}
