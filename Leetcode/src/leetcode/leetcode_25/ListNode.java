package leetcode.leetcode_25;

public class ListNode {
    int val;
    ListNode next;
    
    ListNode() {
        this.val = -1;
        this.next = null;
    }
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
    
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
