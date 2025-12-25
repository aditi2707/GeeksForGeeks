// Node class
class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

// Queue class
class myQueue {
    
    Node head;
    Node tail;
    int n = 0;

    public myQueue() {
        // Initialize your data members
        
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        // check if the queue is empty
        
        if(head == null){
            return true;
        }
        
        return false;
    }

    public void enqueue(int x) {
        // Adds an element x at the rear of the queue.
        
        if(isEmpty()){
            head = new Node(x);
            tail = head;
        }
        else{
            tail.next = new Node(x);
            tail = tail.next;
        }
        n++;
        
        return;
    }

    public void dequeue() {
        // Removes the front element of the queue
        
        if(isEmpty()){
            return;
        }
        
        head = head.next;
        n--;
        
        return;
    }

    public int getFront() {
        // Returns the front element of the queue.
        // If queue is empty, return -1.
        
        if(isEmpty()){
            return -1;
        }
        
        return head.data;
    }

    public int size() {
        // Returns the current size of the queue.
        
        return n;
    }
}
