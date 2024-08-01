class MyQueue {
    Stack<Integer> stack1 , stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        if(stack2.isEmpty()) {
            return -1;
        }else{
            int ele = stack2.pop();
            while(!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return ele;
        }
    }
    
    public int peek() {
        if(!stack2.isEmpty()){
            return stack2.peek();
        }else{
            while(!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
            if(stack2.isEmpty()) return -1;
            int ele = stack2.peek();
            while(!stack2.isEmpty()) {
                stack1.add(stack2.pop());
            }
            return ele;
        }
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */