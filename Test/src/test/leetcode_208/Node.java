package test.leetcode_208;

public class Node {
    public static int NUM_CHAR = 'z' - 'a' + 2;
    public static char END_CHAR = '#';
    
    // character value
    char value;
    
    // array of nodes contains next character. 
    // The first position is for character 'a', the next is for 'b' and so on ...
    // The last character is for '#' to mark end of word
    Node[] nexts;
    
    public Node() {
        nexts = new Node[NUM_CHAR];
    }
    
    public Node(char value) {
        this();
        this.value = value;
    }
    
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(" + value +")\n");
        for (int i = 0; i < nexts.length; i++) {
            if (nexts[i] != null) {
                builder.append(nexts[i]);
            }
        }
        return builder.toString();
    }

}
