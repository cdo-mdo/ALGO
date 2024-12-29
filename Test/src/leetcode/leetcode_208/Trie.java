package test.leetcode_208;

public class Trie {
    Node head;
    
    public Trie() {
        head = new Node();
    }
    
    public void insert(String word) {
        Node node = head;
        
        int pos;
        for (pos = 0; pos < word.length(); pos++) {
            // Check if each character is in the tree
            char c = word.charAt(pos);
            if (node.nexts[c - 'a'] == null) {
                break;
            }
            node = node.nexts[c - 'a'];
        }
        
        if (pos >= word.length()) {
            // check to mark end of word
            if (node.nexts[Node.NUM_CHAR - 1] == null) {
                Node endNode = new Node('#');
                node.nexts[Node.NUM_CHAR - 1] = endNode;
            }
            return;
        }
        
        // Add remaining characters to the tree
        for (int i = pos; i < word.length(); i++) {
            char c = word.charAt(i);
            Node newNode = new Node(c);
            node.nexts[c - 'a'] = newNode;
            node = newNode;
        }
        if (node.nexts[Node.NUM_CHAR - 1] == null) {
            Node endNode = new Node('#');
            node.nexts[Node.NUM_CHAR - 1] = endNode;
        }
        
    }
    
    public boolean search(String word) {
        Node node = head;
        for (int pos = 0; pos < word.length(); pos++) {
            char c = word.charAt(pos);
            if (node.nexts[c - 'a'] == null || node.nexts[c - 'a'].value != c) {
                return false;
            }
            node = node.nexts[c - 'a'];
        }
        
        // Note have end character
        if (node.nexts[Node.NUM_CHAR - 1] == null || node.nexts[Node.NUM_CHAR - 1].value != Node.END_CHAR) {
            return false;
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        Node node = head;
        for (int pos = 0; pos < prefix.length(); pos++) {
            char c = prefix.charAt(pos);
            if (node.nexts[c - 'a'] == null || node.nexts[c - 'a'].value != c) {
                return false;
            }
            node = node.nexts[c - 'a'];
        }
                
        return true;
    }
    
    public String toString() {
        Node node = head;
        return node.toString();
    }
}
