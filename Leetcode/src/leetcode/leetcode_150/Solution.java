package leetcode.leetcode_150;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int sum = stack.pop() + stack.pop();
                stack.push(sum);
            }
            else if (token.equals("-")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int subtract = num2 - num1;
                stack.push(subtract);
            }
            else if (token.equals("*")) {
                int multiply = stack.pop() * stack.pop();
                stack.push(multiply);
            }
            else if (token.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int divide = num2 / num1;
                stack.push(divide);
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(new String[] {"2", "1", "+", "3", "*"}));
        System.out.println(solution.evalRPN(new String[] {"4", "13", "5", "/", "+"}));
        System.out.println(solution.evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
