package leetcode.leetcode_61;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        
        int size = 1;
        ListNode currentEnd = head;
        
        // Get size of list
        while (currentEnd.next != null) {
            size++;
            currentEnd = currentEnd.next;
        }
        
        int num = k % size;
        ListNode newEnd = head;
        for (int i = 1; i < size - num; i++) {
            newEnd = newEnd.next;
        }
        
        // Rotate 
        currentEnd.next = head;
        head = newEnd.next;
        newEnd.next = null;
        
        return head;
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
        
        ListNode res = solution.rotateRight(head, 2);
        
        node = res;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }
}
