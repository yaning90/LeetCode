class MyStack {
    Queue<Integer> queue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        for(int i=0; i<queue.size()-1;i++){
            queue.add(queue.remove());
        }
        queue.remove();
    }

    // Get the top element.
    public int top() {
        for(int i=0; i<queue.size()-1;i++){
            queue.add(queue.remove());
        }
        int top = queue.remove();
        queue.add(top);
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(queue.size()==0){
            return true;
        }else{
            return false;
        }
    }
}
