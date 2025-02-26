package leetcode.leetcode_226;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        if (root.left == null && root.right == null) {
            return root;
        }
        
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        
        return root;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root = new TreeNode(4);
        
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        
        TreeNode res = solution.invertTree(root);
        
        System.out.println(res.val + " " + res.left.val + " " + res.right.val);
        
    }
}
