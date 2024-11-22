class LRUCache {
    class Node{
        int key , val;
        Node next , prev;
        Node(int key , int val){
            this.key = key;
            this.val = val;
            this.next = this.prev = null;
        }
    }
    int capacity;
    Node head = new Node(-1,-1);    
    Node tail = new Node(-1,-1);
    Map<Integer , Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            int ans = node.val;
            deleteNode(node); // remove from in between the cache in O(1) time
            insertNode(node); // add it to the first position of cache
            return ans;
        }else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node node = new Node(key , value);
        if(map.containsKey(key)){
            deleteNode(map.get(key));
        }
        else if(map.size() == this.capacity){
            deleteNode(tail.prev); // tail is (-1 , -1) so the prev of the node will be the element to be removed
        }
        insertNode(node);
    }
    public void insertNode(Node node) {
        map.put(node.key , node);
        node.next = head.next; // (head) --> (head.next) 
        // node --> node.next connect the node with head's list as node.next = null
        head.next = node; // now connect the head.next pointer to node;
        node.next.prev = node;
        node.prev = head;

        // step 1: a ---> b
        //         h and  hn
        // node ----> b <---- a
        // step 2: a ----> node ----> b
        // step 3: node.next.prev i.e b prev to node
        // step 4: node.prev = head i.e set prev node of node from null to head
    }
    public void deleteNode(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // step 0: np <===> n <===> nn
        // step 1: np ---> nn <--- n
        //         |               |
        //          ---------------
        // step 2: node.next.prev = node.prev
        // np <===> nn
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */