package leetcode.leetcode_367;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum  = 0;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(Double.valueOf(sum / size));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        List<Double> res = solution.averageOfLevels(root);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
