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
        if(head == null) return null;
        ListNode curr = head;
        int count = 0;

        while(curr != null && count < k) {
            count ++;
            curr = curr.next;
        }
        if(count == k){
            curr = head;
            ListNode prev = null;
            for(int i = 0 ; i < k ; i ++) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            head.next = reverseKGroup(curr , k);
            return prev;
        }
        return head;
    }
}