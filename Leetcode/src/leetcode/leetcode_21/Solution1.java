package leetcode.leetcode_21;

public class Solution1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode node = res;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            }
            else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        
        if (list1 == null) {
            node.next = list2;
        }
        else {
            node.next = list1;
        }
        
        return res.next;
    }
    
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode n1 = list1;
        System.out.print("\nlist1: ");
        while (n1 != null) {
            System.out.print(n1.val + " ");
            n1 = n1.next;
        }
        
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode n2 = list2;
        System.out.print("\nlist2: ");
        while (n2 != null) {
            System.out.print(n2.val + " ");
            n2 = n2.next;
        }
        
        ListNode res = solution1.mergeTwoLists(list1, list2);
        
        ListNode node = res;
        System.out.println();
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        
    }
}
