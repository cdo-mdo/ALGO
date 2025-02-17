package leetcode.leetcode_25;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        if (k > size) {
            return head;
        }
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prevGroup = dummy;
        ListNode curr = head;
        
        while (true) {
            // Check if there are k nodes left to reverse
            ListNode check = curr;
            for (int i = 0; i < k; i++) {
                if (check == null) return dummy.next;
                check = check.next;
            }
            
            // Reverse k nodes
            
        }
    }
}
