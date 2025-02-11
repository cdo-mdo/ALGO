package leetcode.leetcode_71;

public class Test {
    public static void main(String[] args) {
        String path1 = "/../";
        String[] strs = path1.split("/");
        for (String str: strs) {
            System.out.println("[" + str + "]");
        }
    }
}
