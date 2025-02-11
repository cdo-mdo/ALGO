package leetcode.leetcode_2;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode node = res;
        
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            
            node.next = new ListNode(sum % 10);
            node = node.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        
        return res.next;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(4);
        System.out.println(l1.val + " " + l1.next.val + " " + l1.next.next.val);
        
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(3);
        System.out.println(l2.val + " " + l2.next.val + " " +  l2.next.next.val);
        
        ListNode r = solution.addTwoNumbers(l1, l2);
        System.out.println(r.val + " " + r.next.val + " " + r.next.next.val);
    }
}
