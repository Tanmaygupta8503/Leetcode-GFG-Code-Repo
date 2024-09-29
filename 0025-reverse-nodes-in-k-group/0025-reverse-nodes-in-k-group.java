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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        int listSize = 0;
        while (current != null && listSize < k) {
            current = current.next;
            listSize++;
        }

        if (listSize < k) {
            return head;
        }

        // Reverse the first k nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;   // Save the next node
            curr.next = prev;   // Reverse the link
            prev = curr;        // Move prev forward
            curr = next;        // Move current forward
            count++;
        }

        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }
}
