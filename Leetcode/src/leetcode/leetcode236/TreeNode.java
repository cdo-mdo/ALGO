package leetcode.leetcode236;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {
        
    }
    
    TreeNode(int val) {
        this();
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this(val);
        this.left = left;
        this.right = right;
    }
}
