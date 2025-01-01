package leetcode.leetcode105;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            maps.put(inorder[i], i);
        }
        return build(preorder, maps, 0, preorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, Map<Integer, Integer> maps, int start, int end) {
        TreeNode node = new TreeNode(preorder[start]);
        if (start == end) {
            return node;
        }
        int i;
        for (i = start + 1; i <= end; i++) {
            if (maps.get(preorder[i]).intValue() > maps.get(preorder[start]).intValue()) {
                break;
            }
        }
        System.out.println("DEBUG-0 i = " + i);
        if (i - 1 >= start + 1) {
            node.left = build(preorder, maps, start + 1, i - 1);
        }
        if (i <= end) {
            node.right = build(preorder, maps, i, end);
        }
        
        return node;
    }
    
    public static void main(String[] args) {
//        int[] preorder = {3, 9, 20, 15, 7};
//        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {1, 2};
        int[] inorder = {2, 1};
        
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println(root.toString());
    }
}
