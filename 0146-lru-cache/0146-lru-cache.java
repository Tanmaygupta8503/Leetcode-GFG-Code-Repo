class Node{
    int key , value;
    Node next , prev;
    public Node (int key , int value){
        this.key = key;
        this.value = value;
        this.next = this.prev = null;
    }
}
class LRUCache {
    
    int capacity;
    Node head = new Node(-1 , -1);
    Node tail = new Node(-1 , -1);
    Map <Integer , Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            int ans = node.value;
            delete(node);
            insert(node);
            return ans;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node node = new Node(key , value);
        if(map.containsKey(key)){
            delete(map.get(key));
        } else if(map.size() == this.capacity){
            delete(tail.prev);
        }
        insert(node);
    }
    public void insert(Node node){
        map.put(node.key , node);
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    } 
    public void delete(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */