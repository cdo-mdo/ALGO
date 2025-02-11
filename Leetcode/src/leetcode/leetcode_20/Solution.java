package leetcode.leetcode_20;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            else {
                if (s.charAt(i) == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                else if (s.charAt(i) == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
                else if (s.charAt(i) == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isValid("()"));
//        System.out.println(solution.isValid("()[]{}"));
//        System.out.println(solution.isValid("(]"));
//        System.out.println(solution.isValid("([])"));
//        System.out.println(solution.isValid("["));
        System.out.println(solution.isValid("]"));
    }
}
