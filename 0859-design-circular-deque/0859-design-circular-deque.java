class MyCircularDeque {
    class DLLNode{
        int val;
        DLLNode prev,  next;

        DLLNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    int k, size;
    DLLNode head , tail;
    public MyCircularDeque(int k) {
        this.k = k;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        DLLNode newNode = new DLLNode(value);
        if(isEmpty()){
            head = tail = newNode;
        }else{ // inserting at first position
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size ++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        DLLNode newNode = new DLLNode(value);
        if(isEmpty()){
            head = tail = newNode;
        }else{ //inserting at Last Position
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size ++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }
        if(head == tail){
            head = tail = null;
        }else{
            head = head.next;
            head.prev = null;
        }
        size --;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        if(head == tail){
            head = tail = null; 
        }else{
            tail = tail.prev;
            tail.next = null;
        }
        size --;
        return true;

    }
    
    public int getFront() {
        if(isEmpty()){
            return -1;
        }else{
            return head.val;
        }
    }
    
    public int getRear() {
        if(isEmpty()){
            return -1;
        }else{
            return tail.val;
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */