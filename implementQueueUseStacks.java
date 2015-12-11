
// My version.
class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> stack2 = new Stack<>();
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int ans= stack2.peek();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return ans;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty();
    }
}

// 很好的java类的写法，数据是private，构造函数初始化，共用的函数单独写成小函数
class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public void stack2ToStack1() {
		while (! stack2.isEmpty()) {
			stack1.push(stack2.peek());
			stack2.pop();
		}
	}
    public MyQueue() {
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    public void push(int number) {
        stack2.push(number);
    }

    public int pop() {
        if (stack1.isEmpty()) {
			this.stack2ToStack1();
		}
        return stack1.pop();
    }

    public int peek() {
        if (stack1.isEmpty()) {
			this.stack2ToStack1();
		}
        return stack1.peek();
    }
    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}
