package leetcode.leetcode_82;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next;
            }
            else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        
        ListNode node = head;
        while(node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
        
        ListNode res = solution.deleteDuplicates(head);
        node = res;
        while(node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        
        
    }
}
