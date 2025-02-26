package leetcode.leetcode_129;

public class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0); 
    }
    
    private int sum(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }
        
        currentSum = currentSum * 10 + node.val;
        
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        
        return sum(node.left, currentSum) + sum(node.right, currentSum); 
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        System.out.println(solution.sumNumbers(root));
        
    }
}
