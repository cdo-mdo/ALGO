package leetcode.leetcode_224;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        char[] tokens = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for (char token : tokens) {
            if (token == ' ') {
                // skip blank space
                continue;
            }
            if (token == '(') {
                stack.push(token);
                continue;
            }
            if (Character.isDigit(token)) {
                if (stack.peek().equals("+")) {
                    stack.pop();
                    int sum = Integer.parseInt(stack.pop() + "") + token;
                    stack.push(Character.forDigit(sum, 10));
                }
                else if (stack.peek().equals("-")) {
                    stack.pop();
                    int substract = Integer.parseInt(stack.pop() + "") - token;
                    stack.push(Character.forDigit(substract, 10));
                }
                else if (stack.peek().equals("*")) {
                    stack.pop();
                    int multiply = Integer.parseInt(stack.pop() + "") * token;
                    stack.push(Character.forDigit(multiply, 10));
                }
                else if (stack.peek().equals("/")) {
                    stack.pop();
                    int division = Integer.parseInt(stack.pop() + "") / token;
                    stack.push(Character.forDigit(division, 10));
                }
                else {
                    stack.push(Character.forDigit(token, 10));
                }
                
                    
                }
            }
        }
        
        return 0;
    }
    
    
    
}
