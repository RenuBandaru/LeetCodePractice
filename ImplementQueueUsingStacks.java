/*
U - use two stacks, 
functions: push, peek, pop, empty
edge cases - 
list empty? use empty() method
input is always integers between 1 to 9

M - Stacks


Ex: 1, 2, 3, 4
push                               pop
stack - [1, 2, 3]   1 ->2          [2]
queue - [1, 2, 3]   1 ->2          [1]

P- 

MyQueue() - declare two stacks to be used
push(int x) - pushing like a stack to the back
pop() - 
remove all elements till the last element and return the last element
peek() - return the last element in the stack
empty() - we check if both the stacks are empty

*/
class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
        
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int value = stack2.pop();
        
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        
        return value;
    }
    
    /** Get the front element. */
    public int peek() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int peek = stack2.peek();
        
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        
        return peek;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty());
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
