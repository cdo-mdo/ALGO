package leetcode.leetcode_71;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else if (!strs[i].isEmpty() && !strs[i].equals(".")){
                stack.push(strs[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, "/" + stack.pop());
        }
        return builder.toString();
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/home//foo/"));
        System.out.println(solution.simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(solution.simplifyPath("/../"));
    }
}
