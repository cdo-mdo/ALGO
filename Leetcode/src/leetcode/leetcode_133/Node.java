package leetcode.leetcode_133;

import java.util.List;
import java.util.ArrayList;

public class Node {
    int val;
    List<Node> neighbors;
    
    Node() {
        this.neighbors = new ArrayList<>();
    }
    Node(int val) {
        this();
        this.val = val;
    }
    Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
