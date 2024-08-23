class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // Add your code here.
        Node slow = head , fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                cycle = true;
                break;
            }
        }
        if(!cycle) {
            return 0;
        }
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        } 
        Node start = slow.next;
        int cnt = 1;
        while(start != slow) {
            start = start.next;
            cnt ++;
        }
        return cnt;
        
    }
}
