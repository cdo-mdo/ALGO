package leetcode.leetcode_68;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<StringBuilder> strs = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        
        // allocate word to string by max width
        for (String word: words) {
            if (builder.length() + word.length() <= maxWidth - 1) {
                if (builder.isEmpty()) {
                    builder.append(word);
                }
                else {
                    builder.append(" " + word);
                }
            }
            else {
                strs.add(builder);
                builder = new StringBuilder();
                builder.append(word);
            }
        }
        strs.add(builder);
        
        
        for (int i = 0; i < strs.size(); i++) {
            StringBuilder b = strs.get(i);
            if (b.length() == maxWidth) {
                break;
            }
            
            int spaces = maxWidth - b.length();
            if (i != strs.size() - 1) {
                int from = 0;
                while (spaces > 0) {
                    from = b.indexOf(" ", from);
                    if (from == -1) {
                        from = b.indexOf(" ", 0);
                    }
                    if (from == -1) {
                        b.append(" ");
                        from = b.indexOf(" ", 0);
                    }
                    else {
                        b.insert(from, " ");
                    }
                    while (b.charAt(from) == ' ') {
                        from++;
                        if (from >= b.length()) {
                            from = 0;
                            break;
                        }
                    }
                    spaces--;
                }
            }
            else {
                while (spaces > 0) {
                    b.append(" ");
                    spaces--;
                }
            }
        }
        
        List<String> res = new ArrayList<>();
        strs.forEach(b -> res.add(b.toString()));
        
        
        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String[] str = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> strs = solution.fullJustify(str, 16);
        strs.forEach(s -> System.out.println("[" + s + "]"));
        
        String[] str1 = {"What", "must", "be", "acknowledgement", "shall", "be"};
        List<String> strs1 = solution.fullJustify(str1, 16);
        strs1.forEach(s -> System.out.println("[" + s + "]"));
    }
}
