// Node class
/* class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
} */

// Stack class
class myStack {
    
    Node top;
    int n = 0;

    public myStack() {
        // Initialize your data members
        
        top = new Node(-1);
    }

    public boolean isEmpty() {
        // check if the stack is empty
        
        if(top.data == -1){
            return true;
        } 
        
        return false;
    }

    public void push(int x) {
        // Adds an element x at the rear of the stack.
        
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        n++;
        
        return;
    }

    public void pop() {
        // Removes the front element of the stack.
        
        if(!isEmpty()){
            top = top.next;
            n--;
        }
        
        return;
    }

    public int peek() {
        // Returns the front element of the stack.
        // If stack is empty, return -1.
        
        return top.data;
    }

    public int size() {
        // Returns the current size of the stack.
        
        return n;
    }
}
