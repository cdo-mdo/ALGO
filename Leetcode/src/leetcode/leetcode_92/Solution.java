package leetcode.leetcode_92;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left >= right) {
            return head;
        }
        ListNode res = new ListNode();
        res.next = head;
        ListNode prev = res;
        
        // Step 1: go to element before left
        for (int i = 1; i < left; i++) {
            if (prev.next == null) {
                return head;
            }
            prev = prev.next;
        }
        
        // Step 2: reverse the element from left to right
        ListNode curr = prev.next;
        ListNode prevNode = null;
        ListNode nextNode = null;
        for (int i = 0; i <= right - left; i++) {
            nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextNode;
        }

        // Step 3: connect the reversed list to the original list
        prev.next.next = curr;
        prev.next = prevNode;
        
        return res.next;
        
        
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        ListNode node = head;
        System.out.println();
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
        
        ListNode res = solution.reverseBetween(head, 2, 4);
        
        node = res;
        System.out.println();
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }
}
