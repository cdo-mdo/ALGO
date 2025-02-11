package leetcode.leetcode_290;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        char[] chrs = pattern.toCharArray();
        if (chrs.length != words.length) {
            return false;
        }
        
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char chr = chrs[i];
            String word = words[i];
            if (charToWord.containsKey(chr)) {
                if (!charToWord.get(chr).equals(word)) {
                    return false;
                }
            }
            else {
                charToWord.put(chr, word);
            }
            
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != chr) {
                    return false;
                }
            }
            else {
                wordToChar.put(word, chr);
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dgog"));
    }
}
