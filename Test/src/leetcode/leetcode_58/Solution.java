package leetcode.leetcode_58;

public class Solution {
    public int lengthOfLastWord(String s) {
        String words[] = s.split(" ");
        return words[words.length - 1].length();
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(solution.lengthOfLastWord("luffy is still joyboy"));
    }
}
