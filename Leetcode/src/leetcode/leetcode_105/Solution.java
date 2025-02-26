package leetcode.leetcode_105;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    private Map<Integer, Integer> inorderMap;
    private int preorderIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        
        // Get root value from preorder and increment preorderIndex
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        
        // Get root index in inorder
        int rootIndex = inorderMap.get(rootVal);
        
        // Build left and right subtrees recursively
        root.left = buildTreeHelper(preorder, inorderStart, rootIndex - 1);
        root.right = buildTreeHelper(preorder, rootIndex + 1, inorderEnd);
        
        return root;
    }
}
