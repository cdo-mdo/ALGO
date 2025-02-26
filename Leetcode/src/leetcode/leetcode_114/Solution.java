package leetcode.leetcode_114;

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left == null) {
            return;
        }
        
        flatten(root.right);
        TreeNode temp = root.right;
        flatten(root.left);
        root.right = root.left;
        root.left = null;
        TreeNode node = root.right;
        while (node.right != null) {
            node.left = null;
            node = node.right;
        }
        node.left = null;
        node.right = temp;
    }
    
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left == null) {
            return;
        }
        
        root.left.right = root.right;
        root.right = root.left;
    }
    
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        flatten1(root);
        System.out.println(root.val + " -> " + root.right.val + " -> " + root.right.right.val);
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
//        solution.test1(); 
          
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        
        solution.flatten(root);
        TreeNode node = root;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.right;
        }
                
    }
}
