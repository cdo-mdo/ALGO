package test.leetcode236;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        Map<TreeNode, TreeNode> ancestor = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ancestor.put(root, null);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.equals(p) || node.equals(q)) {
                count++;
            }
            if (count == 2) {
                break;
            }
            if (node.left != null) {
                ancestor.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                ancestor.put(node.right, node);
                queue.add(node.right);
            }
        }
        
        TreeNode aP = p;
        TreeNode aQ = q;
        
        
        while (true) {
            if (aP.equals(aQ)) {
                return aP;
            }
            aQ = ancestor.get(aQ);
            if (aQ == null) {
                aP = ancestor.get(aP);
                aQ = q;
            }
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5); root.right = new TreeNode(1);
        root.left.left = new TreeNode(6); root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0); root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7); root.left.right.right = new TreeNode(4);
        
        TreeNode p1 = root.left; TreeNode q1 = root.right;
        
        System.out.println(solution.lowestCommonAncestor(root, p1, q1).val);
        
        TreeNode q2 = root.left.right.right;
        
        System.out.println(solution.lowestCommonAncestor(root, p1, q2).val);
    }
}
