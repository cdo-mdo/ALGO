package leetcode.leetcode102;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {        
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<List<TreeNode>> queue = new LinkedList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        queue.add(nodes);
        while (!queue.isEmpty()) {
            nodes = queue.poll();
            List<Integer> values = new ArrayList<>();
            List<TreeNode> newNodes = new ArrayList<>();
            nodes.forEach(n -> {
                values.add(n.val);
                if (n.left != null) {
                    newNodes.add(n.left);
                }
                if (n.right != null) {
                    newNodes.add(n.right);
                }
            });
            if (!newNodes.isEmpty()) {
                queue.add(newNodes);
            }
//            System.out.println("DEBUG-1 queue is empty = " + queue.isEmpty());
            result.add(values);
        }
//        System.out.println("DEBUG-2 return");
        
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(root);
        
        result.forEach(l -> System.out.println(l));
        
        System.out.println("end");
        
    }
}
