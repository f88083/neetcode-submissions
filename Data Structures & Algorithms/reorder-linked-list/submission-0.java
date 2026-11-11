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
    public void reorderList(ListNode head) {
        // Find the middle node
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Assign second half head
        ListNode second = slow.next;
        // Detach second half
        slow.next = null;
        // Reverse prep.
        ListNode pre = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = pre;
            pre = second;
            second = tmp;
        }

        second = pre;
        ListNode first = head;
        // Combine
        while (second != null) {
            ListNode tmpFirst = first.next, tmpSec = second.next;

            first.next = second;
            second.next = tmpFirst;

            // Move the pointers
            first = tmpFirst;
            second = tmpSec;
        }
    }
}
