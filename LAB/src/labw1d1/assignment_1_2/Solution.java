package labw1d1.assignment_1_2;

public class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode node = head;
		ListNode prev = null;
		ListNode next = null;
		while (node != null) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		
		return prev;
	}
}
