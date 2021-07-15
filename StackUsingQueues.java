/* UMPIRE

U: implementing a stack (LIFO) using queues (FIFO), time/space?, 2 queues!, only integers? 
M: 2 queues
P: plan 

Example: stack
1 -> 2 -> 3 -> 4

build 2 queues
mystack - initialize them
push - push elements into queue1 (1 -> 2 -> 3 -> 4)
pop - we want to return 4 (NOT head of queue1, which is 1).
      LOOP - dequeue every element in queue1 and add to queue2
      queue2: 4 -> 3 -> 2 -> 1
      dequeue queue2, it returns 4 (value)
      move back all elements from queue2 to queue1
      return value
top - (peek)
      if queue1 isn't empty, move ALL elements to queue2, peek
      move them back
      
      if queue1 empty, just peek queue2
empty - is queue1 & queue2 empty

*/

class MyStack {
    
    //declare 2 queues
    Queue<Integer> q1, q2;

    /** Initialize your data structure here. */
    public MyStack() {
        
        q1 = new LinkedList <>();
        q2 = new LinkedList <>();
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // dequeue elements in q1 UP TO last element in q1 and add them to q2
        while (q1.size()>1 && !q1.isEmpty()){
            q2.add(q1.remove());   // adding up to before 2, 2 is still in q1
        }
        // store value of pop queue2
        int val = q1.remove();   // should be 2 
        
        // return all elements from queue2 to queue1
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
        return val;
    }
    
    /** Get the top element. */
    public int top() {  // peek
        
        // dequeue elements in q1 UP TO last element in q1 and add them to q2
        while (q1.size()>1 && !q1.isEmpty()){
            q2.add(q1.remove());   // adding up to before 2, 2 is still in q1
        }
        // store value of pop queue2
        int top = q1.peek();   // should be 2 
        
        q2.add(q1.remove());
        
        // return all elements from queue2 to queue1
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
        return top;
        
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return (q1.isEmpty() && q2.isEmpty());
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
