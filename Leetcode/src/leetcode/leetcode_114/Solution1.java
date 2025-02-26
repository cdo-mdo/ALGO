package leetcode.leetcode_114;

public class Solution1 {
    public void flatten(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                TreeNode rightMost = node.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                rightMost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
}
