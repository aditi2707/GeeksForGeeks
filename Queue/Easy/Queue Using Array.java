class myQueue {
    
    int[] arr;
    int n;
    int front = -1;
    int rear = -1;

    // Constructor
    public myQueue(int n) {
        // Define Data Structures
        
        arr = new int[n];
        this.n = n;
    }

    public boolean isEmpty() {
        // Check if queue is empty
        
        if(rear < front || front == -1 || rear == -1){
            return true;
        }
        
        return false;
    }

    public boolean isFull() {
        // Check if queue is full
        
        if(rear - front + 1 == n){
            return true;
        }
        
        return false;
    }

    public void enqueue(int x) {
        // Enqueue
        
        if(isFull()){
            return;
        }
        
        if(isEmpty()){
            front = 0;
            rear = 0;
            arr[rear] = x;
        }
        else{
            rear++;
            arr[rear] = x;
        }
        
        return;
    }

    public void dequeue() {
        // Dequeue
        
        if(isEmpty()){
            return;
        }
        
        front++;
        
        return;
    }

    public int getFront() {
        // Get front element
        
        if(isEmpty()){
            return -1;
        }
        
        return arr[front];
    }

    public int getRear() {
        // Get last element
        
        if(isEmpty()){
            return -1;
        }
        
        return arr[rear];
    }
}
