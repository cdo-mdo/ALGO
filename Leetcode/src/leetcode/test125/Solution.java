package leetcode.test125;
/**
 * Solution Valid Palindrome
 */
public class Solution {
    public boolean isPalindrome(String str) {
        if (str.length() == 0) {
            return true;
        }
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            char charLeft = str.charAt(left);
            if (!Character.isLetterOrDigit(charLeft)) {
                left++;
                continue;
            }
            Character charRight = str.charAt(right);
            if (!Character.isLetterOrDigit(charRight)) {
                right--;
                continue;
            }
            if (Character.toLowerCase(charLeft) != Character.toLowerCase(charRight)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";
        String s2 = " ";
        String s3 = "0P";
        Solution solution = new Solution();
//        System.out.println(solution.isPalindrome(s));
//        System.out.println(solution.isPalindrome(s1));
//        System.out.println(solution.isPalindrome(s2));
        System.out.println(solution.isPalindrome(s3));
    }

}
