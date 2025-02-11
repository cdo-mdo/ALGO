package leetcode.leetcode_141;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (true) {
            if (slow == null || fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
            
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        ListNode head = new ListNode(3);
        ListNode pos = new ListNode(2);
        head.next = pos;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = pos;
        System.out.println(solution.hasCycle(head));
        
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        System.out.println(solution.hasCycle(head));

        head = new ListNode(1);
        System.out.println(solution.hasCycle(head));
        
        head = null;
        System.out.println(solution.hasCycle(head));
        
        head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(solution.hasCycle(head));
        
    }

}
