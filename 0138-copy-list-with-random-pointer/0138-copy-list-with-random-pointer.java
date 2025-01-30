/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node , Node> nodeToRandomPointer = new HashMap<>();
        Node dummy = head;
        while(dummy != null) {
            nodeToRandomPointer.put(dummy , new Node(dummy.val));
            dummy = dummy.next;
        }
        dummy = head;
        while(dummy != null) {
            Node copyNode = nodeToRandomPointer.get(dummy);
            copyNode.next = nodeToRandomPointer.get(dummy.next);
            copyNode.random = nodeToRandomPointer.get(dummy.random);
            dummy = dummy.next;
        }
        return nodeToRandomPointer.get(head);
    }
}