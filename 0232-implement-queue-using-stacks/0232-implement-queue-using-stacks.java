class MyQueue {

    Stack<Integer> inputStack;
    Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    // O(1) - Push element into the queue
    public void push(int x) {
        inputStack.push(x);
    }

    // O(1) amortized - Remove element from the queue
    public int pop() {
        if (outputStack.isEmpty()) {
            // Transfer all elements from inputStack to outputStack
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        // If outputStack is still empty, the queue is empty
        if (outputStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return outputStack.pop();
    }

    // O(1) - Return the front element
    public int peek() {
        if (outputStack.isEmpty()) {
            // Transfer elements from inputStack to outputStack if needed
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        // If outputStack is still empty, the queue is empty
        if (outputStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return outputStack.peek();
    }

    // O(1) - Check if the queue is empty
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
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