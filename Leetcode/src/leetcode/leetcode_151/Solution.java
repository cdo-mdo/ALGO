package leetcode.leetcode_151;

public class Solution {
    public String reverse(String s) {
        String[] strs = s.trim().split("  *");
        StringBuilder build = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (i == 0) {
                build.append(strs[i].trim());
            }
            else {
                build.append(strs[i].trim() + " ");
            }
        }
        return build.toString();
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("[" + solution.reverse("the sky is blue") + "]");
        System.out.println("[" + solution.reverse("  hello world  ") + "]");
        System.out.println("[" + solution.reverse("a good   example") + "]");
    }
}
