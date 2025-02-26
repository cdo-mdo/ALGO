package leetcode.leetcode_101;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if ((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
            return false;
        }
        
        return isSameTree(root.left, invertTree(root.right));
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        
        if (p.val != q.val) {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
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
        
        TreeNode root = new TreeNode(1);
        
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
                
        System.out.println(solution.isSymmetric(root));
    }
}
