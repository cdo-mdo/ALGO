package leetcode.leetcode117;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        Queue<List<Node>> queue = new LinkedList<>();
        queue.add(nodes);
        
        while (!queue.isEmpty()) {
            nodes = queue.poll();
            List<Node> newNodes = new ArrayList<>();
            Node prev = null;
            for (Node n: nodes) {
                n.next = prev;
                prev = n;
                if (n.right != null) {
                    newNodes.add(n.right);
                }
                if (n.left != null) {
                    newNodes.add(n.left);
                }
            }
            if (!newNodes.isEmpty()) {
                queue.add(newNodes);
            }
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1, new Node(2), new Node(3), null);
        root.left.left = new Node(4); root.left.right = new Node(5);
        root.right.right = new Node(7);
        
        Solution solution = new Solution();
        solution.connect(root);
        
        System.out.println(root.next);
        System.out.println(root.left.next.val); System.out.println(root.right.next);
        System.out.println(root.left.left.next.val); System.out.println(root.left.right.next.val);
        System.out.println(root.right.right.next);
    }
}
