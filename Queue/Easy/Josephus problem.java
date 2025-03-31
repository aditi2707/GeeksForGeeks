class Solution
{
   public int josephus(int n, int k)
    {
        //Your code here
        
        // Time Complexity : O((n ^ 2))
        // Space Complexity : O(n)
        
        List<Integer> arr = new ArrayList<>();
        
        for(int i = 1; i <= n; i++){
            arr.add(i);
        }
        
        int index = 0;
        
        while(arr.size() > 1){
            int removeInd = (index + k - 1) % arr.size();
            arr.remove(removeInd);
            index = removeInd;
        }
        
        return arr.get(0);
        
        
        // Time Complexity : O(k * (n ^ 2))
        // Space Complexity : O(n)
        
        // Queue<Integer> queue = new LinkedList<>();
        // int c = 1;
        
        // for(int i = 1; i <= n; i++){
        //     queue.add(i);
        // }
        
        // while(queue.size() > 1){
            
        //     int poll = queue.poll();
            
        //     if(c == k){
        //         c = 1;
        //     }
        //     else{
        //         queue.add(poll);
        //         c++;
        //     }
        // }
        
        // return queue.poll();
    }

}
