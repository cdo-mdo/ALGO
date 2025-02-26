package leetcode.leetcode_199;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    // add the value to the result list
                    res.add(node.val);
                }
                
                // Add node at next level to the queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        
        List<Integer> res = solution.rightSideView(root);
        System.out.println(Arrays.toString(res.toArray()));
        
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        
        res = solution.rightSideView(root);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
