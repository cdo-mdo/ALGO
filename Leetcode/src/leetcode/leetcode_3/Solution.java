package leetcode.leetcode_3;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int start = 0;
        int end = 0;
        int len = 0;
        for (end = 1; end < s.length(); end++) {
            for (int i = start; i < end; i++) {
                if (s.charAt(i) == s.charAt(end)) {
                    len = Math.max(end - start, len);
                    start = i + 1;
                }
            }
        }
        len = Math.max(end - start, len);
        return len;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("au"));
    }
}   
