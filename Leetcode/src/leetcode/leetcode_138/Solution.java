package leetcode.leetcode_138;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> originalToCopy = new HashMap<>();
        
        Node res = new Node(-1);
        Node node = head;
        Node copy = res;
        
        // Build copy linked list
        while (node != null) {
            copy.next = new Node(node.val);
            originalToCopy.put(node, copy.next);
            node = node.next;
            copy = copy.next;
        }
        
        // Update random pointer
        node = head;
        copy = res.next;
        while (node != null) {
            if (node.random == null) {
                copy.random = null;
            }
            else {
                copy.random = originalToCopy.get(node.random);
            }
            node = node.next;
            copy = copy.next;
        }
        
        return res.next;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        Node[] nodes = new Node[5];
        nodes[0] = new Node(7);
        nodes[1] = new Node(13);
        nodes[2] = new Node(11);
        nodes[3] = new Node(10);
        nodes[4] = new Node(1);
        
        nodes[0].next = nodes[1];
        nodes[1].next = nodes[2];
        nodes[2].next = nodes[3];
        nodes[3].next = nodes[4];
        nodes[4].next = null;
        
        nodes[0].random = null;
        nodes[1].random = nodes[0];
        nodes[2].random = nodes[4];
        nodes[3].random = nodes[2];
        nodes[4].random = nodes[1];
        
        Node head = nodes[0];
        
        Node copy = solution.copyRandomList(head);
        
        // Test
        Node node = copy;
        int i = 0;
        while (node != null) {
            System.out.println("check pos: " + i);
            if (node.val != nodes[i].val) {
                System.err.println("wrong val at pos: " + i);
                return;
            }
            if (node.random == null) {
                if (nodes[i].random != null) {
                    System.err.println("wrong random 1 at pos: " + i);
                    return;
                }
            }
            else {
                if (nodes[i].random == null) {
                    System.err.println("wrong random 2 at pos: " + i);
                    return;
                }
                if (node.random.val != nodes[i].random.val) {
                    System.err.println("wrong random 3 at pos: " + i);
                    return;
                } 
            }
            node = node.next;
            i++;
        }
        System.out.println("Test OK");
    }
}
