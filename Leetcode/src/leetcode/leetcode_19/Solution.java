package leetcode.leetcode_19;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        
        // Traverse list to get its size
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        
        // Size of list is not long enought to remove the Nth node
        if (size < n) {
            return head;
        }
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        node = dummy;
        for (int i = 1; i <= size - n; i++) {
            node = node.next;
        }
        // Remove the Nth node from the end of the list
        node.next = node.next.next;
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
        
        ListNode res = solution.removeNthFromEnd(head, 2);
        node = res;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        
        
        ListNode head1 = new ListNode(1);
        res = solution.removeNthFromEnd(head1, 1);
        
    }
}
