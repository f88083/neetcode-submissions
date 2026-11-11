/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        ListNode left = dummy;
        dummy.next = head;
        ListNode right = head;

        while (n > 0) {
            right = right.next;
            --n;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        ListNode tmp = left.next; // For garbage
        
        // Delete it
        left.next = left.next.next;
        
        tmp.next = null; // Unlink for garbage

        return dummy.next;
    }
}
