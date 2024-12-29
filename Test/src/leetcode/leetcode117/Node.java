package test.leetcode117;

public class Node {
    int val;
    Node left;
    Node right;
    Node next;
    
    Node() {
        
    }
    
    Node(int val) {
        this();
        this.val = val;
    }
    
    Node(int val, Node left, Node right) {
        this(val);
        this.left = left;
        this.right = right;
    }
    
    Node(int val, Node left, Node right, Node next) {
        this(val, left, right);
        this.next = next;
    }
        
}
