package test.leetcode_208;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        
        trie.insert("apple");
        System.out.println("search for apple " + trie.search("apple"));
        System.out.println("search for app " + trie.search("app"));
        System.out.println("search for app " + trie.startsWith("app"));
        trie.insert("app");
        System.out.println("search for app " + trie.search("app"));
        trie.insert("at");
        trie.insert("apply");
        System.out.println(trie.toString());
    }
}
