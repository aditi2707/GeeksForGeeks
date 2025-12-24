class myStack {
    
    int[] arr;
    int n;
    int top = -1;
    
    // List<Integer> arr;
    // int n;

    public myStack(int n) {
        // Define Data Structures
        
        arr = new int[n];
        this.n = n;
        
        // arr = new ArrayList<>();
        // this.n = n;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        
        if(top == -1){
            return true;
        }
        
        return false;
        
        
        
        // if(arr.size() == 0){
        //     return true;
        // }
        
        // return false;
    }

    public boolean isFull() {
        // check if the stack is full
        
        if(top == n - 1){
            return true;
        }
        
        return false;
        
        
        
        // if(arr.size() == n){
        //     return true;
        // }
        
        // return false;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        
         if(!isFull()){
            top++;
            arr[top] = x;
        }
        
        return;
        
        
        
        // if(!isFull()){
        //     arr.add(x);
        // }
        
        // return;
    }

    public void pop() {
        // Removes an element from the top of the stack
        
        if(!isEmpty()){
            top--;
        }
        
        return;
        
        
        
        // if(!isEmpty()){
        //     arr.remove(arr.size() - 1);
        // }
        
        // return;
    }

    public int peek() {
        // Returns the top element of the stack
        
         if(!isEmpty()){
            return arr[top];
        }
        
        return -1;
        
        
        
        
        // if(!isEmpty()){
        //     return arr.get(arr.size() - 1);
        // }
        
        // return -1;
    }
}
