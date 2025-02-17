package leetcode.leetcode_21;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode node = res;
        ListNode n1 = list1;
        ListNode n2 = list2;
        
        while (n1 != null || n2 != null) {
            if (n1 == null) {
                node.next = new ListNode(n2.val);
                n2 = n2.next;
            }
            else if (n2 == null) {
                node.next = new ListNode(n1.val);
                n1 = n1.next;
            }
            else {
                if (n1.val <= n2.val) {
                    node.next = new ListNode(n1.val);
                    n1 = n1.next;
                }
                else {
                    node.next = new ListNode(n2.val);
                    n2 = n2.next;
                }
            }
            node = node.next;
        }
        
        return res.next;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
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
        System.out.println("\nlist2: ");
        while (n2 != null) {
            System.out.print(n2.val + " ");
            n2 = n2.next;
        }
        
        ListNode res = solution.mergeTwoLists(list1, list2);
        
        ListNode node = res;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        
    }
}
