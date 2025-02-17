package leetcode.leetcode_86;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        
        // Go to the position that has value greater or equal x
        // remember previous position as insert position
        ListNode dummy = new ListNode(-1, head);
        ListNode insertPos = dummy;
        ListNode node = head;
        
        while (node != null) {
            if (node.val >= x) {
                break;
            }
            insertPos = node;
            node = node.next;
        }
        
        // All nodes have value less than x, return
        if (node == null) {
            return head;
        }
        
        // Find all nodes that less than x and insert to insert position
        while (node != null) {
            if (node.val < x) {
                ListNode nodeNext = node.next;
                node.next = insertPos.next;
                insertPos.next = node;
                node = nodeNext;
                insertPos = insertPos.next;
            }
            else {
                node = node.next;
            }
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
        
        ListNode res = solution.partition(head, 3);
        
        node = res;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }
}
