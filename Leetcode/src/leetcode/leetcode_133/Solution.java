package leetcode.leetcode_133;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Map<Node, Node> clones = new HashMap<>();
        
        return dfs(node, clones);
        
    }
    
    Node dfs(Node node, Map<Node, Node> clones) {
        if (clones.containsKey(node)) {
            return clones.get(node);
        }
        
        Node cloned = new Node(node.val);
        clones.put(node, cloned);
        
        // Clone and link neighbors
        for (Node neighbor : node.neighbors) {
            cloned.neighbors.add(dfs(neighbor, clones));
        }
        
        return cloned;
    }
}
