package leetcode.leetcode_392;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        
        int p1 = 0;
        int p2 = 0;
        while (p2 < t.length()) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
                p2++;
            }
            else {
                p2++;
            }
            if (p1 == s.length()) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
        System.out.println(solution.isSubsequence("axc", "ahbgdc"));
        System.out.println(solution.isSubsequence("", "ahbgdc"));
    }
}
