package test.leetcode116;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public Node connect(Node root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        Queue<List<Node>> queue = new LinkedList<>();
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        queue.add(nodes);
        
        while (!queue.isEmpty()) {
            nodes = queue.poll();
            List<Node> newNodes = new ArrayList<>();
            Node prev = null;
            for (Node node: nodes) {
                node.next = prev;
                prev = node;
                if (node.left != null && node.right != null) {
                    newNodes.add(node.right);
                    newNodes.add(node.left);
                }
            }
            if (!newNodes.isEmpty()) {
                queue.add(newNodes);
            }
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2); root.right = new Node(3);
        root.left.left = new Node(4); root.left.right = new Node(5);
        root.right.left = new Node(6); root.right.right = new Node(7);
        
        Solution solution = new Solution();
        root = solution.connect(root);
        System.out.println(root.next);
        System.out.print(root.left.next.val + " "); System.out.println(root.right.next);
        System.out.print(root.left.left.next.val + " "); System.out.print(root.left.right.next.val + " ");
        System.out.print(root.right.left.next.val + " ");System.out.println(root.right.right.next);
        
    }
}
