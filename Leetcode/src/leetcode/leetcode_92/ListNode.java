package leetcode.leetcode_92;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {
        this.val = 0;
        this.next = null;
    }
    ListNode(int val) {
        this();
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
