package leetcode.test_12_28_2;

import java.util.Arrays;

public class Solution {
    public String answerString(String word, int numFriends) {
        int len = word.length() - numFriends + 1;
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        for (int i = chars.length - 1; i >= 0; i--) {
            if (word.indexOf(chars[i]) + len <= word.length()) {
                return word.substring(word.indexOf(chars[i]), word.indexOf(chars[i]) + len);
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        String word = "dbca";
        System.out.println(solution.answerString(word, 2));
        System.out.println(solution.answerString("gggg", 4));
        System.out.println(solution.answerString("b", 1));
        System.out.println(solution.answerString("aann", 2));
    }
}
