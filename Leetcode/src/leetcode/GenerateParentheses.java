package leetcode;

public class GenerateParentheses {

    public static void generateParentheses(int n, int openCount, int closeCount, String currentString) {
        // Base case: If the current string has reached the desired length, print it
        if (currentString.length() == 2 * n) {
            System.out.println(currentString);
            return;
        }

        // If the number of open parentheses is less than 'n', add an open parenthesis
        if (openCount < n) {
            generateParentheses(n, openCount + 1, closeCount, currentString + "(");
        }

        // If the number of close parentheses is less than the number of open ones, add a close parenthesis
        if (closeCount < openCount) {
            generateParentheses(n, openCount, closeCount + 1, currentString + ")");
        }
    }

    public static void main(String[] args) {
        int n = 2; // Specify the number of pairs of parentheses
        generateParentheses(n, 0, 0, "");
        
        String s;
    }
} 
