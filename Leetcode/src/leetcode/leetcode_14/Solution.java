package leetcode.leetcode_14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        String minStr = "";
        for (String str: strs) {
            if (minLength > str.length()) {
                minLength = str.length();
                minStr = str;
            }
        }
        
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (index < minLength) {
            boolean match = true;
            for (String str: strs) {
                if (minStr.charAt(index) != str.charAt(index)) {
                    match = false;
                    break;
                }
            }
            if (match == false) {
                break;
            }
            index++;
        }
        
        return minStr.substring(0, index);
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
    }
}
