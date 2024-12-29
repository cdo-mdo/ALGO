package test.leetcode105;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
    
    @Override
    public String toString() {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder build = new StringBuilder();
        build.append("[");
        build.append(val + ", ");
        if (left != null) {
            queue.add(left);
        }
        if (right != null) {
            queue.add(right);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            build.append(node.val + ", ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        build.append("]");
        return build.toString();
    }
}
